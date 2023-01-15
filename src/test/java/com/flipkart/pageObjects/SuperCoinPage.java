package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class SuperCoinPage extends BaseClass{

	
	public WebDriver ldriver;
	
	public SuperCoinPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//a[@href='https://www.flipkart.com/plus/coins-activity']")
	@CacheLookup
	WebElement ViewCoinActivity;



	
	public void clkViewCoinActivity()
	{
		 ViewCoinActivity.click();;
	}
	

	
}