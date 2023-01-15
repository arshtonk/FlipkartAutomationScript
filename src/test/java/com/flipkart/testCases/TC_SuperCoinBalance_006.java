package com.flipkart.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.LoginPage;
import com.flipkart.pageObjects.SuperCoinActivity;
import com.flipkart.pageObjects.SuperCoinPage;

public class TC_SuperCoinBalance_006 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void superCoinBalance() throws InterruptedException 
	{
//		TC_LoginTest_001 login= new TC_LoginTest_001();
//		login.loginTest();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		HomePage homePage= new HomePage(driver);			
		homePage.hoverMyAccountdrp();			
		logger.info("Moved to my account element");
		
		homePage.clickSuperCoinZone();
		logger.info("Clicked on SuperCoinZone ");
		
		SuperCoinPage superCoinPage= new SuperCoinPage(driver);
		superCoinPage.clkViewCoinActivity();
		logger.info("Clicked on viewCoinActivity ");
		
		
		SuperCoinActivity superCoinActivity=new SuperCoinActivity(driver);
		List<WebElement> DebitedCoins=superCoinActivity.debitedSuperCoins();
//		int sum=0;
//		for(WebElement el: DebitedCoins)
//		{
//			String redCoin=el.getText();
//			 redCoin= redCoin.replaceAll("\\s", "");
//			int i=Integer.parseInt(redCoin);
//			sum=sum+i;
//			System.out.println(redCoin+ " "+ sum);
//		}
		
		int DebitedCoinssum= sumOfCoins(DebitedCoins);
		logger.info("DebitedCoinssum is " + DebitedCoinssum);
		
		List<WebElement> CreditedCoins=superCoinActivity.creditedSuperCoins();
		int creditedSuperCoins= sumOfCoins(CreditedCoins);
		logger.info("CreditedSuperCoins is " + creditedSuperCoins);
	}
	
	
	
	public static int sumOfCoins(List<WebElement> coins)
	{
		int sum=0;
		for(WebElement el: coins)
		{
		String coin=el.getText();
		coin= coin.replaceAll("\\s", "");
		int i=Integer.parseInt(coin);
		sum=sum+i;
		}
		return sum;
	}
	
}
