package com.toolsqa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.toolsqa.keywords.Constants;
import com.toolsqa.keywords.Keywords;

public class HomePage {
	WebDriverWait wait=new WebDriverWait(Constants.driver,20);
	
	@FindBy(css="div.branding>a[href='https://www.toolsqa.com/']")
	private WebElement logo;

	@FindBy(xpath ="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border "
			+ "border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='facebook']")
	private WebElement facebookLink ;
	
	@FindBy(xpath="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border"
			+ " border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='twitter']")
	private WebElement twitterLink;
	
	@FindBy(xpath ="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border"
			+ " border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='you-tube']")
	private WebElement youtubeLink;
	
	@FindBy(xpath ="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border"
			+ " border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='rss']")
	private WebElement rssLink;
	
	@FindBy(xpath ="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border"
			+ " border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='linkedin']")
	private WebElement linkedinLink;
	
	@FindBy(xpath ="//div[@class='soc-ico show-on-desktop in-top-bar-right in-menu-second-switch custom-bg disabled-border"
			+ " border-off hover-accent-bg hover-disabled-border  hover-border-off first last']//child::a[@class='instagram']")
	private WebElement instagramLink;
	
//	@FindBy(css ="nav>#primary-menu>li")
//	private WebElement menuList;
//	
	@FindBy(xpath ="//nav//div[@class='mini-search show-on-desktop near-logo-first-switch in-menu-second-switch popup-search"
			+ " custom-icon first last']//a[@class='submit text-disable']//i")
	private WebElement searchIcon;
	
	@FindBy(xpath ="//div//div[@class='mini-search show-on-desktop near-logo-first-switch in-menu-second-switch popup-search"
			+ " custom-icon first last act']//input[@class='field searchform-s']")
	private WebElement searchText;
	
	@FindBy(xpath ="//div[@class='mini-search show-on-desktop near-logo-first-switch in-menu-second-switch popup-search"
			+ " custom-icon first last act']//a[@class='search-icon']")
	private WebElement search;
	
	@FindBy(css ="nav>ul#primary-menu>li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children"
			+ ".menu-item-20916.has-children")
	private WebElement video;
	
	@FindBy(xpath ="//nav//ul[@class='sub-nav level-arrows-on']//li"
			+ "//a[@href='https://www.toolsqa.com/selenium-webdriver/selenium-webdriver-basics-video-tutorials/']")
	private WebElement freeSeleniumBasicVideo;
	
	@FindBy(css ="nav>ul#primary-menu>li>a")
	private List<WebElement> menuItems;
	
//	@FindBy(xpath ="//div[@id='cp_id_fbcbd-1']//div[@class='cp-overlay-close cp-image-close "
//			+ "cp-inside-close cp-adjacent-right']//img")
//	private WebElement popup;
//	
//	public void closePopup() throws InterruptedException {
//		Thread.sleep(10000);
//	//	popup.click();
//		if(popup != null) {
//			popup.click();
//		}
//		else {
//			System.out.println("Popup not found.");
//		}
//	}
	
	public void validateLogo() {
		logo.isDisplayed();
	}
	
	public void clickOnFacebookLink() {
		facebookLink.click();
		
	}
	
	public void clickOnTwitterLink() {
		twitterLink.click();
	}
	
	public void clickOnYoutubeLink() {
		youtubeLink.click();
	}
	
	public void clickOnRssLink() {
		rssLink.click();
	}
	
	public void clickOnLinkedinLink() {
		linkedinLink.click();
	}
	
	public void clickOnInstagramLink() {
		instagramLink.click();
	}
	
	
//	public ArrayList checkMenuList() {
//		List<WebElement> subNavItems = (List<WebElement>) menuList; //or use:- primary-menu>li>a 
//		
//		ArrayList actualsubNavItems = new ArrayList<String>(); 
//		Iterator<WebElement> itr = subNavItems.iterator();
//		while (itr.hasNext()) {
//			actualsubNavItems.add(itr.next().getText());	
//		}
//		return actualsubNavItems;	
//	} 
//	
	public ArrayList validateMenuList() {
	return Keywords.verifyMenuItems(menuItems);
	}
	
	public void validateSearchIcon() {
		searchIcon.isDisplayed();
	}
	
	public void clickOnSearchIcon() {
		searchIcon.click();
	}
	
	public void enterTextOnSearchBox(String value) {
		searchText.sendKeys(value);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public void clickOnVideo() {
		video.click();
	}
	
	public FreeSeleniumVideoPage clickOnFreeSeleniumBasicVideo() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(video).build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(freeSeleniumBasicVideo));
		freeSeleniumBasicVideo.click();
		return new FreeSeleniumVideoPage();
	}
	
}
