package config;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import context.Objects;
import log.Log;

public class DataSetter {
	
	public static Configuration configuration;
	
	public static void getConfiguration() {
		try {
			File file = new File ("src/main/java/configuration/ConfigurationFile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
			Unmarshaller jabxUnmarshaller = jaxbContext.createUnmarshaller();
			configuration = (Configuration) jabxUnmarshaller.unmarshal(file);
		}catch (Exception ex){
			log.Log.info(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	public static void dispose() {
		configuration = null;
	}
}
