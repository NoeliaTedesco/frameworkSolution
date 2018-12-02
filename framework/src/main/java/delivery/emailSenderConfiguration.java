package delivery;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class emailSenderConfiguration {
	
	private List<String> emailGroup;
	private String emailFrom;
	private String mailAuth;
	private String mailStarttls;
	private String smptHost;
	private String port;
	private String user;
	private String password;
	private List<String> attachedFilePath;
	
	public emailSenderConfiguration() {
		
	}

	public emailSenderConfiguration(List<String> emailGroup, String emailFrom, String mailAuth, String mailStarttls,
			String smptHost, String port, String user, String password, List<String> attachedFilePath) {
		super();
		this.emailGroup = emailGroup;
		this.emailFrom = emailFrom;
		this.mailAuth = mailAuth;
		this.mailStarttls = mailStarttls;
		this.smptHost = smptHost;
		this.port = port;
		this.user = user;
		this.password = password;
		this.attachedFilePath = attachedFilePath;
	}

	public List<String> getEmailGroup() {
		return emailGroup;
	}

	@XmlElement
	public void setEmailGroup(List<String> emailGroup) {
		this.emailGroup = emailGroup;
	}

	public String getEmailFrom() {
		return emailFrom;
	}
	@XmlElement
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getMailAuth() {
		return mailAuth;
	}
	@XmlElement
	public void setMailAuth(String mailAuth) {
		this.mailAuth = mailAuth;
	}

	public String getMailStarttls() {
		return mailStarttls;
	}
	@XmlElement
	public void setMailStarttls(String mailStarttls) {
		this.mailStarttls = mailStarttls;
	}

	public String getSmptHost() {
		return smptHost;
	}
	@XmlElement
	public void setSmptHost(String smptHost) {
		this.smptHost = smptHost;
	}

	public String getPort() {
		return port;
	}
	@XmlElement
	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}
	@XmlElement
	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getAttachedFilePath() {
		return attachedFilePath;
	}
	@XmlElement
	public void setAttachedFilePath(List<String> attachedFilePath) {
		this.attachedFilePath = attachedFilePath;
	}
	
	
	
	
	
	
	

}
