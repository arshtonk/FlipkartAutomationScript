package com.flipkart.testCases;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;

public class TC_TotalItems_004 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void totalItems() throws InterruptedException 
	{
//		TC_LoginTest_001 login= new TC_LoginTest_001();
//		login.loginTest();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		HomePage homePage= new HomePage(driver);
		List <WebElement> items=homePage.totalItems();
		
		Assert.assertEquals(items.size(), 9);
		logger.info("Number of Items are equal as expected");
		
		List<String> ExpectedItems= Arrays.asList("Top Offers", "Mobiles & Tablets", "Electronics", "TVs & Appliances", 
				"Fashion", "Beauty", "Home & Furniture", "Flights", "Grocery");
		
		int  i=0;
		for (WebElement webElement : items) 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			if(webElement.getText().equalsIgnoreCase(ExpectedItems.get(i)))
			{
				logger.info(webElement.getText()+ " matched to " + ExpectedItems.get(i));
				i++;
				Assert.assertTrue(true);
			}
			else
			{
				//System.out.println(webElement.getText());
				Assert.assertTrue(false);
				logger.info("Item didn't matched");
				break;
			}
		}
		logger.info("TotalItems TestCase Passed");
	}
}
