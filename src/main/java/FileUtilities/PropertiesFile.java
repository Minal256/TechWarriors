package FileUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.toolsqa.keywords.Constants;

public class PropertiesFile {
//	public static Properties prop;
	
	public static String getProperty(String key) 
	{
		String value=null;
		try {
			Constants.fis=new FileInputStream("E:\\Eclipse programs\\ToolsQAFramework\\src\\main\\resources\\config.properties");
            Constants.prop=new Properties();
            Constants.prop.load(Constants.fis);
            value=Constants.prop.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Unable to open repository");
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
