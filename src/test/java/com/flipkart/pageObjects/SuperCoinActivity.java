package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class SuperCoinActivity extends BaseClass{

	
	public WebDriver ldriver;
	
	public SuperCoinActivity(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//div[@style='color: rgb(255, 0, 0);']")
	@CacheLookup
	List<WebElement> DebitedSuperCoins;
	
	@FindBy(xpath="//div[@style='color: rgb(0, 128, 0);']")
	@CacheLookup
	List<WebElement> CreditedSuperCoins;


	
	public List<WebElement> debitedSuperCoins()
	{
		return DebitedSuperCoins;
	}
	
	
	public List<WebElement> creditedSuperCoins()
	{
		return CreditedSuperCoins;
	}
	
	
}