package com.flipkart.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.LoginPage;
import com.flipkart.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData", groups = {"Login"})
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User provided"); 
		
		lp.setPassword(pwd);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Login in Clicked");
		

		if (driver.getTitle().equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
			Thread.sleep(5000);
		
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'My Account')]"));
			//Creating object of an Actions class
			Actions action = new Actions(driver);

			//Performing the mouse hover action on the target element.
			action.moveToElement(ele).perform();
			//Click on Logout
			driver.findElement(By.xpath("//div[text()='Logout']")).click();
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
			logger.info("Logout Passed");
			
			
		} else {
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
	
	}
		
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/flipkart/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	
	
}
