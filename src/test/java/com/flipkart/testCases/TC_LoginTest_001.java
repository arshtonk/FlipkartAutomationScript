package com.flipkart.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test(groups = {"Login"})
	public void loginTest() throws InterruptedException  {
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided"); 
		
		lp.setPassword(password);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Login in Clicked");
	}		
   
	@Test(dependsOnMethods= {"loginTest"})
		public void TitleCheckTest()
		{
			if (driver.getTitle().equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) 
			{	
				Assert.assertTrue(true);
				logger.info("Title Matched");	
			} else 
			{
				Assert.assertTrue(false);
				logger.info("Login Failed");
			}		
		}

}
