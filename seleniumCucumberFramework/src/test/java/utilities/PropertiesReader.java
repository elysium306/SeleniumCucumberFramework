package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	
private static Properties config;

	
	static {
		
		try {
			File file = new File("./src/test/resources/env_variables/env_variables.properties");
			FileInputStream input = new FileInputStream(file);
			config = new Properties();
			config.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return config.getProperty(key);
	}
	

}
