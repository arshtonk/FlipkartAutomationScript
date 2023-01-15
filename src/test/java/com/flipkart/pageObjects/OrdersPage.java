package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.testCases.BaseClass;

public class OrdersPage extends BaseClass{

	
	public WebDriver ldriver;
	
	public OrdersPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(xpath="//span[@class='row _1kkfO3 BqOr_g']")
	@CacheLookup
	List<WebElement> TotalOrders;

	@FindBy(xpath="//input[@placeholder='Search your orders here']")
	@CacheLookup
	WebElement OrdersSearchBar;

	@FindBy(xpath="//div[@class='col-2-12 _1_SN5_']")
	@CacheLookup
	List<WebElement> OrdersPrice;
	
	
	
	public List<WebElement> allOrders()
	{
		 return TotalOrders;
	}
	
	public List<WebElement> ordersPrice()
	{
		 return OrdersPrice;
	}
	
	public void searchOrder(String orderName)
	{
		OrdersSearchBar.sendKeys(orderName + Keys.ENTER);
	}
	
}
