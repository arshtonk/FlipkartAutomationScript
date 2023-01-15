package com.flipkart.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;
import com.flipkart.pageObjects.OrdersPage;

public class TC_Carousel_008 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void carousel() throws InterruptedException, AWTException 
	{
//		TC_LoginTest_001 login= new TC_LoginTest_001();
//		login.loginTest();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		Thread.sleep(5000);
		HomePage homePage= new HomePage(driver);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		int i=0;
		while(i<10)
		{
			 robot = new Robot();
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			i++;
		}
			
		//scrollToElement(homePage.recentlyViewed());
		logger.info("Moved to recently viewed element");
		
		List<WebElement> recentlyViewedItems= homePage.recentlyViewedItems();
		List<String> recentlyViewItems= new ArrayList<>();
		
		for(WebElement el: recentlyViewedItems)
		{
			recentlyViewItems.add(el.getAttribute("title"));
			logger.info("Element are "+ el.getAttribute("title"));
		}
		logger.info("Added all recently viewed element into list");
		logger.info("No. of items in recently viewed element list are : "+ recentlyViewItems.size());
		
		while(homePage.clickCarouselRightButton().isDisplayed())
		{
			homePage.clickCarouselRightButton().click();
			logger.info("Carousel Right Button Clicked");
		}
	}

}
