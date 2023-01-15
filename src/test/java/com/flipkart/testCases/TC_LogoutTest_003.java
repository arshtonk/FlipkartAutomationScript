package com.flipkart.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;

public class TC_LogoutTest_003 extends BaseClass {
	
	@Test(groups = {"Login"})
	public void logoutTest() throws InterruptedException  {
		
		TC_LoginTest_001 login= new TC_LoginTest_001();
		login.loginTest();
		
		HomePage homePage= new HomePage(driver);			
		homePage.hoverMyAccountdrp();			
		logger.info("Moved to my account element");
		
		homePage.clickLogout();
		logger.info("Clicked on Logout ");

		LoginPage loginPage= new LoginPage(driver);
	
		if(loginPage.loginLnk() > 0)
		{
			Assert.assertTrue(true);
			logger.info("Logout Passed ");
			
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Button is not visible so Logout failed ");
		}			
	}
}
