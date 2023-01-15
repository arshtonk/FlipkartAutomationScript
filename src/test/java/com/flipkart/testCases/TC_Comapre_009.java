package com.flipkart.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.ClickedItemPage;
import com.flipkart.pageObjects.ComparePage;
import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.ItemSearchedPage;
import com.flipkart.pageObjects.LoginPage;

public class TC_Comapre_009 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void comapreMobiles() throws InterruptedException, AWTException 
	{
//		driver.get(baseURL);
//		driver.manage().window().maximize();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		int realmeSearchAttempts = 0;
	    while(realmeSearchAttempts < 2) 
	    {
	        try {
	        	HomePage homePage= new HomePage(driver);
	    		waitForElementToappear(homePage.searchBar());
	        	homePage.clickSearchBar("realme C30s");
	    		logger.info("Searched realme");
	            break;
	        } catch(StaleElementReferenceException e) {
	        	System.out.println("realmeSearchAttempts");
	        }
	        realmeSearchAttempts++;
	    }
	    
	    ItemSearchedPage ItemSearchedPage= new ItemSearchedPage(driver);
	    ItemSearchedPage.realmePhone();
	    windowHandler("realme C30s ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com");
	    
	    ClickedItemPage clickedItemPage= new ClickedItemPage(driver);
	    clickedItemPage.clkCompare();
	    logger.info("Clicked on Comapre CheckBox");
	    
	    clickedItemPage.clkCompareButton();
	    logger.info("Clicked on Comapre Button");
	    
	    Thread.sleep(2000);
	    ComparePage comparePage= new ComparePage(driver);
	    
	    //1
	    waitForElementToBeClickable(comparePage.clickChooseBrand());
	    comparePage.clickChooseBrand().click();
	    logger.info("Clicked on Choose Brand 1");
	    
	    waitForElementToBeClickable(comparePage.mobilePhone("realme"));
        scrollToElement(comparePage.mobilePhone("realme"));
        comparePage.mobilePhone("realme").click();
	    logger.info("Clicked on Realme");
	    
	    
	    Thread.sleep(4000);
	    //waitForElementToBeClickable(comparePage.clickChooseProduct(1));
	    comparePage.clickChooseProduct().click();
	    logger.info("Clicked on Choose Product 1");
	    
	    scrollToElement(comparePage.mobilePhone("realme C31 (Light Silver, 32 GB)"));
	    comparePage.mobilePhone("realme C31 (Light Silver, 32 GB)").click();
	    logger.info("Clicked on Mobile Product");
	    
	    
	    //2
	    waitForElementToBeClickable(comparePage.clickChooseBrand());
	    comparePage.clickChooseBrand().click();
	    logger.info("Clicked on Choose Brand 2");
	    
	    try {
	    	waitForElementToBeClickable(comparePage.mobilePhone("APPLE"));
	        scrollToElement(comparePage.mobilePhone("APPLE"));
	        comparePage.mobilePhone("APPLE").click();
		    logger.info("Clicked on APPLE");
	    }
	    catch(StaleElementReferenceException e)
	    {
	    	waitForElementToBeClickable(comparePage.mobilePhone("APPLE"));
	        scrollToElement(comparePage.mobilePhone("APPLE"));
	        comparePage.mobilePhone("APPLE").click();
		    logger.info("Clicked on APPLE");	
	    }
	    
	    
	    Thread.sleep(4000);
	    //waitForElementToBeClickable(comparePage.clickChooseProduct(1));
	    comparePage.clickChooseProduct().click();
	    logger.info("Clicked on Choose Product 2");
	    
	    scrollToElement(comparePage.mobilePhone("APPLE iPhone 11 (White, 128 GB)"));
	    comparePage.mobilePhone("APPLE iPhone 11 (White, 128 GB)").click();
	    logger.info("Clicked on Mobile Product");
	    
	    
	  //3
	    waitForElementToBeClickable(comparePage.clickChooseBrand());
	    comparePage.clickChooseBrand().click();
	    logger.info("Clicked on Choose Brand 3");
	    
	    waitForElementToBeClickable(comparePage.mobilePhone("Huawei"));
        scrollToElement(comparePage.mobilePhone("Huawei"));
        comparePage.mobilePhone("Huawei").click();
	    logger.info("Clicked on Huawei");
	    
	    
	    Thread.sleep(4000);
	    //waitForElementToBeClickable(comparePage.clickChooseProduct(1));
	    comparePage.clickChooseProduct().click();
	    logger.info("Clicked on Choose Product 3");
	    
	    scrollToElement(comparePage.mobilePhone("Huawei P9 (Titanium Grey, 32 GB)"));
	    comparePage.mobilePhone("Huawei P9 (Titanium Grey, 32 GB)").click();
	    logger.info("Clicked on Mobile Product");
	    
	    
	    List<WebElement> rating=comparePage.ratingList();
	    int i=0;
		for(WebElement el: rating)
		{
			if(i==0)
		    	System.out.println("Rating of realme C30s is: " + el.getText());
			else if(i==1)
		    	System.out.println("Rating of realme C31 is: " + el.getText());
			else if(i==2)
		    	System.out.println("Rating of Apple iphone 11 is: " + el.getText());
			else if(i==3)
		    	System.out.println("Rating of Huawei is: " + el.getText());
			i++;
		}
		
	    List<WebElement> colour=comparePage.colourList();
	    int j=0;
		for(WebElement el: colour)
		{
			if(j==0)
		    	System.out.println("Rating of realme C30s is: " + el.getText());
			else if(j==1)
		    	System.out.println("Rating of realme C31 is: " + el.getText());
			else if(j==2)
		    	System.out.println("Rating of Apple iphone 11 is: " + el.getText());
			else if(j==3)
		    	System.out.println("Rating of Huawei is: " + el.getText());
			j++;
		}
	}	
}