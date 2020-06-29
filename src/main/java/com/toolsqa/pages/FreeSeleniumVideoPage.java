package com.toolsqa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.keywords.Constants;
import com.toolsqa.keywords.Keywords;
import com.toolsqa.tests.Base;

public class FreeSeleniumVideoPage {
	
	@FindBy(css ="h1.entry-title")
	private WebElement seleniumVideoTxt;

	@FindBy(xpath ="//div[@class='sidebar-content widget-divider-off']//div[@class='textwidget']//input[@name='email']")
	private WebElement newsLetter;
	
	@FindBy(xpath ="//div[@class='textwidget']//input[@value='Subscribe']")
	private WebElement subscribe;
	
	@FindBy(xpath ="//h2[contains(text(),'Selenium Browser Command Video')]")
	private WebElement seleBrowCmmdVideoTxt;
	
	@FindBy(xpath ="//a[@href=\"https://www.youtube.com/watch?v=4srNVaBSLG8\"]"
			+ "//ancestor::div[@class='ytp-chrome-top ytp-show-cards-title']")
	private WebElement seleniumBrowserCmmdVideo;
	
	@FindBy(xpath ="//iframe[@src='//www.youtube.com/embed/4srNVaBSLG8']")
	private WebElement iframe;
	 
	@FindBy(xpath ="//li//a[@href='https://www.toolsqa.com/']")
	private WebElement homeTxt;
	
	@FindBy(xpath ="//div//a[@id='close-fixedban']//img")
	private WebElement fixedBan;
	
	@FindBy(css ="div>section#custom_html-2.widget_text.widget.widget_custom_html.wf-cell.wf-1-4>div.textwidget.custom-html-widget>b>a")
	private List<WebElement> siteLinks;
	
	public void validateSeleniumVideoTxt() {
		 seleniumVideoTxt.isDisplayed();
	}
	
	public void subscribeToNewsLetter() throws InterruptedException {
		newsLetter.sendKeys("bhasme.minal@gmail.com");
		fixedBan.click();
		Thread.sleep(2000);
		subscribe.click();
	}
	
	public void validateSeleniumBrowserCommandVideoTxt() {
		seleBrowCmmdVideoTxt.isDisplayed();
	}
	
	public void clickOnSeleniumBrowserCommandVideo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.scrollBy(150,800)");
		Constants.driver.switchTo().frame(iframe);
		//Thread.sleep(3000);
		seleniumBrowserCmmdVideo.click();
	}
	
	public  HomePage clickOnHomeTxt() {
		homeTxt.click();
		return new HomePage();

	}
	
	public ArrayList<String> validateSiteLinksList() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.scrollBy(2200,15000)");
	//	js.executeScript("window.scrollBy(0,1000)");
		return Keywords.selectListValue(siteLinks);
	}
	
	public void validateRecentTutorialsList() {
		

	}
}




