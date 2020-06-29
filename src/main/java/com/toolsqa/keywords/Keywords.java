package com.toolsqa.keywords;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	
	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
			
		case "Safari":
			Constants.driver = new SafariDriver();
			break;

		default:
			System.err.println("Invalid Browser name" + browsername);
			break;
		}
	}

	public static void launchUrl(String url) {
		Constants.driver.get("http://www.toolsqa.com");
	}

	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}
	
	public static String getPageTitle() {
		String title = Constants.driver.getTitle();
		return title;
	}
	
	public static ArrayList verifyMenuItems(List<WebElement> elements) {
		List<WebElement> subNavItems=  (elements);
		
		
		ArrayList actualSubNavItems = new ArrayList<String>();
		
		Iterator<WebElement> itr=subNavItems.iterator();
		while(itr.hasNext()) {
			actualSubNavItems.add(itr.next().getText());
		}
		return actualSubNavItems;
	}
	
	public static void windowHandle() {
		String  parentWindow = Constants.driver.getWindowHandle();
		
		Set<String> childWindow = Constants.driver.getWindowHandles();
		for (String child : childWindow) {
			while (!parentWindow.equalsIgnoreCase(child)) {
				Constants.driver.switchTo().window(child).close();
			}
		}
		
	}
	
	public static List<String> readJsonFile(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsparser = new JSONParser();
		Object unitObj = jsparser.parse(new FileReader(filePath)); 
		JSONObject jsObj = (JSONObject) unitObj;
		
		List<String> expectedList = new ArrayList();
		
		JSONArray jsArray = (JSONArray) jsObj.get("Site Links");
		
		//----JSONArray data is converted into String array-----//
		String s[] = new String [jsArray.size()];
		
		for (int i = 0; i < jsArray.size(); i++) {
			s[i] = (String) jsArray.get(i);
			System.out.println("String array Length :"+s.length);
		}
		
		//------Pass String array data to List<String>
		for (int j = 0; j < jsArray.size(); j++) {
			expectedList.add(j , s[j]);
			System.out.println("Expected List size :"+expectedList.size());
		}
		System.out.println("Expected List :"+expectedList);
		return expectedList;
	}
	
	public static ArrayList<String> selectListValue(List<WebElement> element) {
		List<WebElement> liList = element;
		
		ArrayList<String> actualList = new ArrayList<String>();
		Iterator<WebElement> itr = liList.iterator();
		while (itr.hasNext())
		{
			actualList.add(itr.next().getText());
			System.out.println("Actual List size :"+actualList.size());
		}
		System.out.println("Actual List :"+actualList);
		return actualList;
	}
	
	public static void closeBrowser() {
		Constants.driver.quit();	
	}
}
