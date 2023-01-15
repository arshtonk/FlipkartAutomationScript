package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class HomePage extends BaseClass{

	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//div[contains(text(),'My Account')]")
	@CacheLookup
	WebElement MyAccountDrp;
	
	
	@FindBy(xpath="//div[text()='Logout']")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath="//div[text()='Orders']")
	@CacheLookup
	WebElement lnkOrders;
	
	@FindBy(xpath="//div[text()='SuperCoin Zone']")
	@CacheLookup
	WebElement lnkSuperCoinZone;
	
	@FindBy(xpath="//div[text()='Grocery']/ancestor::div[@class='_37M3Pb']/child::*")
	@CacheLookup
	List<WebElement> allItems;

	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	@CacheLookup
	WebElement searchBar;
	
	@FindBy(xpath="//span[text()='Recently Viewed']")
	@CacheLookup
	WebElement recentlyViewed;
	
	@FindBy(xpath="//a[@class='_2rpwqI']")
	@CacheLookup
	List<WebElement> recentlyViewedItems;
	
	@FindBy(xpath="(//div[@class='_2kgArB _2CP_Bu'])[10]")
	@CacheLookup
	WebElement carouselRightButton;
	
	
	public void hoverMyAccountdrp() throws InterruptedException
	{	
		Thread.sleep(2000);
		waitForElementToappear(MyAccountDrp); 
		
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(MyAccountDrp).perform();
	}
	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public WebElement clickCarouselRightButton()
	{
		return carouselRightButton;
	}
	
	public WebElement recentlyViewed()
	{
		return recentlyViewed;
	}
	
	public List<WebElement> recentlyViewedItems()
	{
		return recentlyViewedItems;
	}
	
	public void clickOrders()
	{
		lnkOrders.click();
	}
	
	public void clickSuperCoinZone()
	{
		lnkSuperCoinZone.click();
	}
	
	public List totalItems()
	{
		return allItems;
	}
	
	public void clickSearchBar(String itemName)
	{
		searchBar.sendKeys(itemName + Keys.ENTER);
	}
	
	public WebElement searchBar()
	{
		return searchBar;
	}
	
	
	
}
