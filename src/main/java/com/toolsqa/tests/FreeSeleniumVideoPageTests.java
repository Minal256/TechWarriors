package com.toolsqa.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toolsqa.keywords.Constants;
import com.toolsqa.keywords.Keywords;
import com.toolsqa.pages.FreeSeleniumVideoPage;
import com.toolsqa.pages.HomePage;

import junit.framework.Assert;

public class FreeSeleniumVideoPageTests extends Base{
	
	FreeSeleniumVideoPage fSVideoPage; 
	HomePage homePage;
	@BeforeMethod
	public void setup() throws InterruptedException {
		homePage = PageFactory.initElements(Constants.driver, HomePage.class); //home page class chi method access karaychi aahe mhnun homepage classs cha object create kela
		homePage.clickOnFreeSeleniumBasicVideo();
		fSVideoPage = PageFactory.initElements(Constants.driver, FreeSeleniumVideoPage.class);
	}

	@Test(priority = 1)
	public void verifySeleniumVideoText() {
		fSVideoPage.validateSeleniumVideoTxt();
	}
	
	@Test(priority = 2, enabled = true)
	public void verifySubscribeToNewsLetter() throws InterruptedException {
		fSVideoPage.subscribeToNewsLetter();
		System.out.println(Constants.driver.getTitle());
	}
	
	@Test(priority = 3,enabled = true)
	public void verifySeleniumBrowserCommandVideoText() throws InterruptedException {
		Thread.sleep(10000);
		fSVideoPage.validateSeleniumBrowserCommandVideoTxt();
	}
	
	@Test(priority = 4, enabled = false)
	public void verifySeleniumBrowserCommandVideoClickable() throws InterruptedException {
		fSVideoPage.clickOnSeleniumBrowserCommandVideo();
		System.out.println(Constants.driver.getTitle());
	}
	
	@Test(priority = 5,enabled = false)
	public void verifyHomeTextBackToHomePage() {
		fSVideoPage.clickOnHomeTxt();
	}
	
	@Test(priority = 6, enabled = true)
	public void verifySiteLink() throws FileNotFoundException, IOException, ParseException {
		 List<String> expected = Keywords.readJsonFile("E:\\Eclipse programs\\ToolsQAFramework\\src\\main\\resources\\FooterLinks.json");
		 List<String> actual = fSVideoPage.validateSiteLinksList();
		 Assert.assertEquals(expected, actual);
	}
}
