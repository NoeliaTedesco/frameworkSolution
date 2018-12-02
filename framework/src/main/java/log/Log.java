package log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import helpers.StepHelper;
import helpers.XMLHelper;

import static config.DataSetter.configuration;

public class Log {

	private static Logger logger = Logger.getLogger(Log.class.getName());

	public static void initilizedLoger() {
		DOMConfigurator.configure(configuration.getLog4jPath());
	}

	public static void SuccessStep(String step) {
		try {
			String status = "Exitoso";
			XMLHelper.object.getPasos().put(step, status);
			XMLHelper.object.setEstado(status);
			logger.info(step + ": " + status);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}
	}

	public static void FailStep(String step) {
		try {
			String status = "Error";
			XMLHelper.object.getPasos().put(step, status);
			XMLHelper.object.setEstado(status);
			StepHelper.takeScreenShot(base.Base.driver, step);
			logger.info(step + ": " + status);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}
	}

	 public static void startTestCase(String sTestCaseName) {
	        try {
	            logger.info("Start test: " + sTestCaseName);
	        } catch (Exception ex) {

	        }
	    }
	    
	    public static void endTestCase(String sTestCaseName) {
	        try {
	            logger.info("End test: " + sTestCaseName);
	        } catch (Exception ex) {

	        }
	    }
	    
	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}
}
