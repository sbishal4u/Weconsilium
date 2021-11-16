package com.org.weconsilium.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	 WebDriver driver=null;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;	
	}
	
	@FindBy(xpath ="//div[@class='form-login-signup']/form/div[5]/button")
	public WebElement LoginBtn;
	
	//Validation on Email and Password
	@FindBy(xpath ="//span[contains(text(),'Please Enter Email Address')]")
	WebElement EmailAlert;
	
	@FindBy(xpath ="//span[contains(text(),'Please Enter Password.')]")
	WebElement PwdAlert;
	
    //Input Email
	@FindBy(xpath ="//input[@id='Email']")
	WebElement InputEmail;
	
	@FindBy(xpath ="//input[@id='Password']")
	WebElement InputPassword;
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();	
	}
	
	public String validatealertEmail()
	{
		return EmailAlert.getText();
		
	}
	
	
	

}
