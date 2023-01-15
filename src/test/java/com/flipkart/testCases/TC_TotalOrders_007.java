package com.flipkart.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;
import com.flipkart.pageObjects.OrdersPage;
import com.flipkart.pageObjects.SuperCoinActivity;
import com.flipkart.pageObjects.SuperCoinPage;

public class TC_TotalOrders_007 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void totalOrders() throws InterruptedException 
	{
//		TC_LoginTest_001 login= new TC_LoginTest_001();
//		login.loginTest();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		HomePage homePage= new HomePage(driver);			
		homePage.hoverMyAccountdrp();			
		logger.info("Moved to my account element");
		
		homePage.clickOrders();
		logger.info("Clicked on Orders");
		
		Thread.sleep(4000);
		OrdersPage ordersPage= new OrdersPage(driver);
	   List<WebElement> Orders=ordersPage.allOrders();
	   logger.info("Total Orders are "+ Orders.size());
	   
	   
	   for(WebElement el:Orders)
	   {
		   logger.info("Orders are "+ el.getText());
	   }
	  //Assert.assertEquals(Orders.size(), 18);
	   
	   ordersPage.searchOrder("Rich Dad Poor Dad");
	
	   List<WebElement> ordersPrice=ordersPage.ordersPrice();
	   logger.info("Price of Rich Dad Poor Dad is: "+ ordersPrice.get(0).getText());
	   Assert.assertEquals(ordersPrice.get(0).getText(), "₹290");
	   
	   
	} 

}
