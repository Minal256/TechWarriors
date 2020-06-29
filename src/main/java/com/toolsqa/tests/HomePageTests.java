package com.toolsqa.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toolsqa.keywords.Constants;
import com.toolsqa.keywords.Keywords;
import com.toolsqa.pages.FreeSeleniumVideoPage;
import com.toolsqa.pages.HomePage;

import FileUtilities.PropertiesFile; 
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTests extends Base {

//	WebDriverWait wait=new WebDriverWait(Constants.driver,20);

	HomePage homePage;  //create homepage reference
	FreeSeleniumVideoPage fSVideoPage; 

	@BeforeMethod
	public void setUp() throws InterruptedException {
		homePage = PageFactory.initElements(Constants.driver, HomePage.class); //initialize ref.
		fSVideoPage = PageFactory.initElements(Constants.driver, FreeSeleniumVideoPage.class);
	
	}
	
//	@Test(priority = 1)
//	public void verifyPopup() throws InterruptedException {
//	 	homePage.closePopup();
//	 	homePage.acceptCookies();
//	}
	
	@Test(priority = 1)
	public void verifytoolsqaHomepageTitle() {
	//	Thread.sleep(6000);
		Keywords.getPageTitle();
	}
	
	@Test(priority = 2)
	public void verifyToolsqaLogo() {
		// homePage = PageFactory.initElements(Constants.driver, HomePage.class);
		homePage.validateLogo();
	}

	@Test(priority = 3 ,enabled = false)
	public void verifyFacebookLink() {
		homePage.clickOnFacebookLink();
	}
	
	@Test(priority = 4 ,enabled = false)
	public void verifyTwitterLink() {
		homePage.clickOnTwitterLink(); 
	}
	
	@Test(priority = 5, enabled = false)
	public void verifyYouTubeLink() {
		homePage.clickOnYoutubeLink(); 
	}
	
	@Test(priority = 6, enabled = false)
	public void verifyRssLink() {
		homePage.clickOnRssLink(); 
	}
	
	@Test(priority = 7, enabled = false)
	public void verifyLinkedinLink() {
		homePage.clickOnLinkedinLink(); 
	}
	
	@Test(priority = 8, enabled = false)
	public void verifyInstagramLink() {
		homePage.clickOnInstagramLink();
	//	System.out.println(Constants.driver.getTitle());
	}
	
	@Test(priority = 9)
	public void verifyMenuItems() {
		String[] expected= {"HOME","TUTORIAL","SELENIUM TRAINING","VIDEOS","BLOGS","DEMO SITES","ABOUT"};
		boolean b = homePage.validateMenuList().containsAll(Arrays.asList(expected));
		Assert.assertTrue(b);
	}
	
	@Test(priority = 10, enabled = false)
	public void verifySearchIconLabel() {
		homePage.validateSearchIcon();
	}
	
	@Test(priority = 11, enabled = true)
	public void verifySearchIconClickable() {
		System.out.println(Constants.driver.getTitle());
		homePage.clickOnSearchIcon();
	}
	
	@Test(priority = 12, enabled = true)
	public void verifySearchBox() {
		homePage.enterTextOnSearchBox(PropertiesFile.getProperty("search"));
		homePage.clickOnSearch();
	}
//	@Test
//	public void verifyMenuList()  {
//		homePage = PageFactory.initElements(Constants.driver, HomePage.class);
//		homePage.checkMenuList();
//	}
	
//	@Test(priority = 9 )
//	public void verifyFreeSeleniumBasicVideo() throws InterruptedException {
//		homePage.clickOnFreeSeleniumBasicVideo();
//		System.out.println(Constants.driver.getTitle());
//	}
	
}
