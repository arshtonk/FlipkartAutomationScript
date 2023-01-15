package com.flipkart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class ClickedItemPage extends BaseClass{

	
	public WebDriver ldriver;
	
	public ClickedItemPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//button[text()='Add to cart']")
	@CacheLookup
	WebElement clickAddToCart;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	@CacheLookup
	WebElement addToCart;
	
	@FindBy(xpath="//label[text()='Compare']")
	@CacheLookup
	WebElement clkCompare;

	@FindBy(xpath="//span[text()='COMPARE']")
	@CacheLookup
	WebElement clkCompareButton;
	
	
	public WebElement addToCart()
	{
		return addToCart;
	}
	
	public void clkCompareButton()
	{
		 clkCompareButton.click();;
	}

	
	public void clickAddToCart()
	{
		clickAddToCart.click();;
	}
	
	public void clkCompare()
	{
		clkCompare.click();;
	}
	
}
