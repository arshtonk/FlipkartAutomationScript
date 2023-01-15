package com.flipkart.testCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.CartPage;
import com.flipkart.pageObjects.ClickedItemPage;
import com.flipkart.pageObjects.HomePage;
import com.flipkart.pageObjects.ItemSearchedPage;
import com.flipkart.pageObjects.LoginPage;

public class TC_AddToCart_005 extends BaseClass{

	@Test(groups = { "NoLogin"})
	public void addToCart() throws InterruptedException 
	{
//		TC_LoginTest_001 login= new TC_LoginTest_001();
//		login.loginTest();

		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickcloseArrow();
		
		int eggBoilerSearchAttempts = 0;
	    while(eggBoilerSearchAttempts < 2) 
	    {
	        try {
	        	HomePage homePage= new HomePage(driver);
	    		waitForElementToappear(homePage.searchBar());
	        	homePage.clickSearchBar("Egg Boiler");
	    		logger.info("Searched Egg Boiler");
	            break;
	        } catch(StaleElementReferenceException e) {
	        	System.out.println("eggBoilerSearchAttempts");
	        }
	        eggBoilerSearchAttempts++;
	    }
		
		
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
//		List<WebElement> searchList= driver.findElements(By.xpath("//span[text()='egg boiler']"));
//		logger.info("Saved names of all Egg Boiler in list");
//		
//		for(WebElement el:searchList)
//		{
//			System.out.println(el.getText());
//			if(el.getText().equalsIgnoreCase("Egg Boiler"))
//			{
//				el.click();
//			}
//		}
		
		
				
//		if(itemSearchedPage.checkBox3Star().isSelected()==false)
//		{
//			itemSearchedPage.checkBox3Star().click();
//			logger.info("Clicked on 3 Star CheckBox");
//		}
	    ItemSearchedPage itemSearchedPage;
		
		int Star3ClickAttempts = 0;
	    while(Star3ClickAttempts < 2) 
	    {
	        try {
	        	 itemSearchedPage= new ItemSearchedPage(driver);
	    		waitForElementToappear(itemSearchedPage.checkBox3Star());
	        	itemSearchedPage.checkBox3Star().click();
	        	logger.info("Clicked on 3 Star CheckBox");
	            break;
	        } catch(StaleElementReferenceException e) {
	        	System.out.println("Star3ClickAttempts");
	        }
	        Star3ClickAttempts++;
	    }
	    

	    
	    int eggBoilerClickAttempts = 0;
	    while(eggBoilerClickAttempts < 2) 
	    {
	        try {
	        	 itemSearchedPage= new ItemSearchedPage(driver);
	     		scrollToElement(itemSearchedPage.eggBoiler());
	     		waitForElementToappear(itemSearchedPage.eggBoiler());
	     		itemSearchedPage.eggBoiler().click();
	     		logger.info("Egg Boiler Selected");
	            break;
	        } catch(StaleElementReferenceException e) {
	        	System.out.println("eggBoilerClick attempts");
	        }
	        eggBoilerClickAttempts++;
	    }
	    
		
		windowHandler("NOVA Blue Electric Egg Boiler NEC 1530 Egg Cooker Price in India - Buy Longway Eggo Egg Cooker online at Flipkart.com");
		logger.info("Moved to child Window");
	
		ClickedItemPage clickedItemPage= new ClickedItemPage(driver);
		waitForElementToappear(clickedItemPage.addToCart());
		
		clickedItemPage.clickAddToCart();
		logger.info("Clicked on add to Cart");
		
		CartPage cartPage= new CartPage(driver);
		waitForElementToappear(cartPage.priceDetails());
		cartPage.clickRemoveFromCart();
		logger.info("Clicked on Remove from Cart");
		

//	     Alert alert = driver.switchTo().alert();
//		 alert.accept();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[2]")).click();
		 logger.info("Item removed from Cart");
	
	}
}
