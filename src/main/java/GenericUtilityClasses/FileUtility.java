package GenericUtilityClasses;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable
	{	
		FileInputStream fis = new FileInputStream("./FileStore/CommonD.properties");
		Properties prob=new Properties();
		prob.load(fis);
		String data=prob.getProperty(key);	
		return data;	
	}
	
}




