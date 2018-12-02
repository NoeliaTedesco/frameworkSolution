package initializer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import base.Base;
import config.DataSetter;
import helpers.XMLHelper;
import log.Log;
import report.ReportConfiguration;
import delivery.emailSender;
import static config.DataSetter.configuration;

public class InitilizeHook extends Base {

	public static void openReport() {
		ReportConfiguration.getReportConfig();
	}
	
	public static void closeReport() {
		ReportConfiguration.exitReport();
		
	}
	public static void openContextData(String testName) {
		XMLHelper.leerXml(testName);
	}

	public static void closeContextData(String testName) {
		XMLHelper.guardarXml(testName);
	}

	public static void openDelivery() {
		emailSender.initilializeEmailDeliveryConfiguration();
		
	}
	
	public static void closeDelivery() {
		emailSender.exitDelivery();
	}
	
	
	public static void openLogger() {
		Log.initilizedLoger();
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public static void openConfiguration() {
		DataSetter.getConfiguration();
	}

	public static void closeConfiguration() {
		DataSetter.dispose();
	}

	public static void openBrowser() {
		String tipoDeBrowser = configuration.getBrowser();

		switch (tipoDeBrowser) {
		case "Chrome": {
			System.setProperty("webdriver.chrome.driver", configuration.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			setDriver(new ChromeDriver(options));
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			break;

		}
		case "Internet Explorer": {
			System.setProperty("webdriver.ie.driver", configuration.getIEDriverPath());
			driver = new InternetExplorerDriver();
			break;

		}
		default: {
			System.setProperty("webdriver.chrome.driver", configuration.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			setDriver(new ChromeDriver(options));
			break;
		}
		}

	}

}
