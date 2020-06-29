package com.toolsqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.toolsqa.keywords.Constants;
import com.toolsqa.keywords.Keywords;

public class Base extends Keywords{

	// Logger log = Logger.getLogger("Base");
	 
		@BeforeTest
		public void launchBrowser() throws InterruptedException {
		//	PropertyConfigurator.configure("log4j.properties");
		//	log.info("************ Launching Chrome Browser ************");
			Keywords.openBrowser("Chrome");
		//	log.info("*********** Opening application URL ************");
			Keywords.launchUrl("http://www.toolsqa.com");
			Keywords.maximizeBrowser();
		//	Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			Constants.driver.findElement(By.xpath("//a[@id='cookie_action_close_header']")).click();
			Thread.sleep(25000);
//			Constants.driver.findElement(By.xpath("//div[@class='cp-animate-container smile-animated smile-fadeInDownBig']//div//img")).click();
//
			try{
				Constants.driver.findElement(By.xpath("//div[@class='cp-modal cp-modal-window-size']"
						+ "//div[@class='cp-animate-container smile-animated smile-fadeInDownBig']"
						+ "//div[@class='cp-overlay-close cp-image-close cp-inside-close cp-adjacent-right']"
						+ "//img[@src='https://www.toolsqa.com/wp-content/plugins/convertplug/modules/assets/images/rounded_black.png']")).click();
			}catch(NoSuchElementException e) {
				System.out.println("PopUp not found");
			}
			
		}
		
		
		@AfterTest
		public void quitBrowser() {
		//	log.info("************* close Browser ***********");
		//	Keywords.closeBrowser();	
		}
		
		
}
