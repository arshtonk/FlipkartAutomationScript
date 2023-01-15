package com.flipkart.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.flipkart.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void setup(String br)
	{
		logger = Logger.getLogger("eCommerce"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		
		
		if (br.equals("firefox")) {
			// Firefox Browser
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			// opens the browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (br.equals("ie")) {
			// opens the browser
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	public String captureScreenShot(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		System.out.println("Screenshot taken");
		return destinationFile;
	}
	
	public void waitForElementToappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void windowHandler(String WindowTitle)
	{
		Set <String> handelvalues = driver.getWindowHandles();
		
		for(String h:handelvalues)
		{
			String title = driver.switchTo().window(h).getTitle();
			
			if (title.equals(WindowTitle)) {
				//driver.close();
				break;
			}
		}
	}
	
	public void scrollToElement(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	
	
	
}
