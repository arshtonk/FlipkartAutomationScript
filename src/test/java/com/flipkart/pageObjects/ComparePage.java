package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class ComparePage extends BaseClass{

	
	public WebDriver ldriver;
	
	public ComparePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='_3LWZlK']")
	@CacheLookup
	List<WebElement> Rating;
	
	@FindBy(xpath="//div[@class='_1l5usX']//parent::div//child::div[text()='Color']")
	@CacheLookup
	List<WebElement> colour;
	
	
	public List<WebElement> ratingList()
	{
		return Rating;
	}
	
	public List<WebElement> colourList()
	{
		return colour;
	}

	public WebElement clickChooseBrand()
	{
		return driver.findElement(By.xpath("//div[text()='Choose Brand']"));
	}
	
	public WebElement clickChooseProduct()
	{
		return driver.findElement(By.xpath("//div[@class='_1l5usX']//parent::div//child::div[text()='Color']//following-sibling::div"));
	}
	
	public WebElement mobilePhone(String Phone)
	{
		return driver.findElement(By.xpath("//div[text()='"+Phone+"']"));
	}
	

}
