package config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {

	private String browser;
	private String ambiente_desarrollo;
	private String ambiente_testing;
	private String ambiente_homologacion;
	private String chromeDriverPath;
	private String IEDriverPath;
	private String log4jPath;
	private String delivery;
	private String deliveryPath;
	private String reportPath;
	private String reportRepository;
	private String imageRepository;
	private String imagePath;

	public Configuration() {
	}

	public String getDeliveryPath() {
		return deliveryPath;
	}

	@XmlElement
	public void setDeliveryPath(String deliveryPath) {
		this.deliveryPath = deliveryPath;
	}
	
	public String getBrowser() {
		return browser;
	}
	

	@XmlElement
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getAmbiente_desarrollo() {
		return ambiente_desarrollo;
	}

	@XmlElement
	public void setAmbiente_desarrollo(String ambiente_desarrollo) {
		this.ambiente_desarrollo = ambiente_desarrollo;
	}

	public String getAmbiente_testing() {
		return ambiente_testing;
	}

	@XmlElement
	public void setAmbiente_testing(String ambiente_testing) {
		this.ambiente_testing = ambiente_testing;
	}

	public String getAmbiente_homologacion() {
		return ambiente_homologacion;
	}

	@XmlElement
	public void setAmbiente_homologacion(String ambiente_homologacion) {
		this.ambiente_homologacion = ambiente_homologacion;
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}

	public String getIEDriverPath() {
		return IEDriverPath;
	}
	@XmlElement
	public void setIEDriverPath(String iEDriverPath) {
		IEDriverPath = iEDriverPath;
	}
	
	@XmlElement
	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}

	public String getLog4jPath() {
		return log4jPath;
	}

	@XmlElement
	public void setLog4jPath(String log4jPath) {
		this.log4jPath = log4jPath;
	}

	public String getDelivery() {
		return delivery;
	}

	@XmlElement
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getReportPath() {
		return reportPath;
	}

	@XmlElement
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getReportRepository() {
		return reportRepository;
	}

	@XmlElement
	public void setReportRepository(String reportRepository) {
		this.reportRepository = reportRepository;
	}

	public String getImageRepository() {
		return imageRepository;
	}

	@XmlElement
	public void setImageRepository(String imageRepository) {
		this.imageRepository = imageRepository;
	}

	public String getImagePath() {
		return imagePath;
	}

	@XmlElement
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Configuration(String browser, String ambiente_desarrollo, String ambiente_testing,
			String ambiente_homologacion, String chromeDriverPath, String IEDriverPath, String log4jPath, String delivery, String reportPath,
			String reportRepository, String imageRepository, String imagePath, String deliveryPath) {
		super();
		this.browser = browser;
		this.ambiente_desarrollo = ambiente_desarrollo;
		this.ambiente_testing = ambiente_testing;
		this.ambiente_homologacion = ambiente_homologacion;
		this.chromeDriverPath = chromeDriverPath;
		this.log4jPath = log4jPath;
		this.delivery = delivery;
		this.reportPath = reportPath;
		this.reportRepository = reportRepository;
		this.imageRepository = imageRepository;
		this.imagePath = imagePath;
		this.IEDriverPath = IEDriverPath;
		this.deliveryPath = deliveryPath;
	}

}
