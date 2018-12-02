package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import log.Log;
import static config.DataSetter.configuration;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.google.common.io.Files;

public class StepHelper {
	
	public static String emailGenerator() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQURSTWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() <4) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
			
		}
		String saltStr = salt.toString();
		saltStr = "AutoIt" + saltStr + "@correo.com";
		return saltStr;
	}

	public static void takeScreenShot(WebDriver driver, String imageName) {
		File Directory = new File(configuration.getImageRepository());
		
		try {
			if(Directory.isDirectory()) {
				File imagen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
				Date date = new Date();
				String dateF = dateFormat.format(date);
				Files.copy(imagen, new File(Directory.getAbsolutePath() + "\\" + dateF + ".png"));
				
			}
		}catch(Exception ex) {
		log.Log.info(ex.getMessage());
		}
	}
}
