package com.toolsqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClosePopup {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.toolsqa.com");
		driver.manage().window().maximize();
		
	//	driver.findElement(By.xpath("//a[@id='cookie_action_close_header']")).click();
		
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='cp-animate-container smile-animated smile-fadeInDownBig']//div//img")).click();
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("/div//img[@src=\"https://www.toolsqa.com/wp-content/plugins/convertplug/modules/assets/images/rounded_black.png\']")));
//		action.build().perform();
//		driver.findElement(By.xpath("//div//img[@src=\"https://www.toolsqa.com/wp-content/plugins/convertplug/modules/assets/images/rounded_black.png\"]"
//				+ "//ancestor::div[@class='cp-module cp-modal-popup-container  cp_id_fbcbd cp-modal-every-design-container ']")).click();
		
	}

}
