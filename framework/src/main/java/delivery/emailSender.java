package delivery;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import config.DataSetter;
import context.PreObjects;
import helpers.XMLHelper;
import log.Log;

public class emailSender {
	
	public static emailSenderConfiguration emailConfiguration;
	
	public static void getEmailDeliveryConfiguration() {
		try {
			File file = new File(DataSetter.configuration.getDeliveryPath());
			JAXBContext jaxbContext = JAXBContext.newInstance(emailSenderConfiguration.class);
			Unmarshaller unmarsheller = jaxbContext.createUnmarshaller();
			emailConfiguration = (emailSenderConfiguration) unmarsheller.unmarshal(file);
			
		}catch (Exception ex) {
		Log.info(ex.getMessage());
		}		
	}
	
	public static void initilializeEmailDeliveryConfiguration() {
		getEmailDeliveryConfiguration();
		
	}
	
	public static void sendEmail() {
		String from = emailConfiguration.getEmailFrom();
		Properties props = new Properties();
		props.put("mail.smtp.auth", emailConfiguration.getMailAuth());
		props.put("mail.smtp.starttls.enable", emailConfiguration.getMailStarttls());
		props.put("mail.smtp.host",  emailConfiguration.getSmptHost());
		props.put("mail.smtp.port",  emailConfiguration.getPort());
		
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfiguration.getUser(),
                        emailConfiguration.getPassword());
            }
        });
        
        try {
        	Message message = new MimeMessage(session);
        	message.setFrom(new InternetAddress (emailConfiguration.getEmailFrom()));
        	for (String e : emailConfiguration.getEmailGroup()) {
        		message.addRecipient(Message.RecipientType.TO, new InternetAddress(e));
        		
        	}
        	message.setSubject(subjectBuilderMail());
        	BodyPart messageBodyPart = new MimeBodyPart();
        	messageBodyPart.setContent(bodyBuilderMail(), "text/html");
        	Multipart multipart = new MimeMultipart();
        	multipart.addBodyPart(messageBodyPart);
        	messageBodyPart = new MimeBodyPart();
        	String filename = DataSetter.configuration.getReportRepository();
        	DataSource source = new FileDataSource(filename);
        	messageBodyPart.setDataHandler(new DataHandler(source));
        	multipart.addBodyPart(messageBodyPart);
        	message.setContent(multipart);
        	Transport.send(message);  
        }catch(Exception ex) {
        	log.Log.info(ex.getMessage());
        }
		
	}
	
	
	public static String subjectBuilderMail() {
		String subject = "";
		subject += "REGRESION :: VERSION ["+ XMLHelper.object.getVersion()+"] :: ";
		subject += "SPRINT ["+ XMLHelper.object.getSprint()+"] :: ";
		subject += getDate();
		return subject;
		
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyymmdd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}
	
	
	public static String bodyBuilderMail() {
        String body = "<!DOCTYPE html><html>";
        body += "<head>"
                + "This mail contains information about the execution of"
                + " automated tests of the day ";
        body += getDate() + "<head><body>";
        body += "<br>" + "<b>Sprint</b>: " + XMLHelper.object.getSprint();
        body += "<br>" + "<b>Version</b>: " + XMLHelper.object.getVersion();
        body += "<br>"
                + "<br>";
        body += "<table width='100%' border='1' align='center'>"
                + "<tr>"
                + "<th>Id test</th>"
                + "<th>Version</th>"
                + "<th>Priority</th>"
                + "<th>Sprint</th>"
                + "<th>Duration</th>"
                + "<th>Status</th>"
                + "<tr>";
        for (PreObjects o : XMLHelper.preObjects) {
            body += "<tr>"
                    + "<td>" + o.obj.getNombreDePrueba() + "</td>";
            body += "<td>" + o.obj.getVersion() + "</td>";
            body += "<td>" + o.obj.getPrioridad() + "</td>";
            body += "<td>" + o.obj.getSprint() + "</td>";
            body += "<td>" + o.obj.getTiempoFinal() + "</td>";
            body += "<td>" + o.obj.getEstado() + "</td>";
        }

        body += "</table>"
                + "<br><br>"
                + "Automatic Delivery"
                + "<br>"
                + "<b>Arksoft Systems</b>"
                + "<br>"
                + "</body>"
                + "</html>";

        return body;

    }
	
	public static void exitDelivery() {
		sendEmail();
		
	}

}
