package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class ItemSearchedPage extends BaseClass{

	
	public WebDriver ldriver;
	
	public ItemSearchedPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//div[text()='3★ & above']")
	@CacheLookup
	WebElement checkBox3Star;
	
	
	@FindBy(xpath="//a[text()='NOVA Blue Electric Egg Boiler NEC 1530 Egg Cooker']")
	@CacheLookup
	WebElement selectEggBoiler;
	
	@FindBy(xpath="//a[text()='NOVA Blue Electric Egg Boiler NEC 1530 Egg Cooker']")
	@CacheLookup
	WebElement eggBoiler;
	
	@FindBy(xpath="//div[text()='Customer Ratings']")
	@CacheLookup
	WebElement customerRatings;

	@FindBy(xpath="//div[text()='realme C30s (Stripe Blue, 64 GB)']")
	@CacheLookup
	WebElement realmePhone;
	

	
	public WebElement checkBox3Star()
	{
		return checkBox3Star;
	}
	
	public void realmePhone()
	{
		 realmePhone.click();
	}
	
	
	public WebElement eggBoiler()
	{
		return eggBoiler;
	}
	
	public void selectEggBoiler()
	{
		 selectEggBoiler.click();;
	}
	
	public WebElement customerRatings()
	{
		return customerRatings;
	}
	
}
