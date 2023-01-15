package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[text()='Login']")
	@CacheLookup
	List<WebElement> lnkLogin;

	@FindBy(xpath="//span[text()='Enter Email/Mobile number']/ancestor::div[@class='IiD88i _351hSN']/input")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//span[text()='Enter Password']/ancestor::div[@class='IiD88i _351hSN']/input")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//span[text()='Login']/ancestor::button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//button[text()='✕']")
	@CacheLookup
	WebElement closeArrow;
	
	public void setUserName(String uname) 
	{
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickcloseArrow()
	{
		closeArrow.click();
	}
	
	
	public int loginLnk()
	{
		
		return lnkLogin.size();  
	}
	
	
}
