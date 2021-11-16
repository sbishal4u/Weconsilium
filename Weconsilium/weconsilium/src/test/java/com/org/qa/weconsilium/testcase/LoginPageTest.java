package com.org.qa.weconsilium.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.org.weconsilium.qa.pageobject.LoginPage;
import com.org.weconsilium.qa.utils.TestUtils;

public class LoginPageTest
{
	LoginPage login;
	public static WebDriver _driver;
	Logger Log= LogManager.getLogger(LoginPageTest.class);
	
	static ExtentReports extent;
	ExtentSparkReporter spark;
	
	@BeforeClass
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--headless");
		_driver = new ChromeDriver(opt);
		
		extent =new ExtentReports();
		spark=new ExtentSparkReporter("LoginPageTest.html");
		extent.attachReporter(spark);
		
		
		//_driver = new ChromeDriver();
		login =new LoginPage(_driver);
		_driver.manage().window().maximize();
		_driver.get("https://weconsilium-qa.azurewebsites.net/user/login");
		_driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void ValidateThetitleOfPage() throws InterruptedException
	{
		extent.createTest("ValidateThetitleOfPage");
		
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title, "Weconsilium");	
		Thread.sleep(5000);
		System.out.println("Title of the page has been Verified");		
	}
	
	@Test(priority = 2)
	public void ClickLoginButtonTest() throws InterruptedException
	{		
		extent.createTest("Validate the Login Button is Clicked");
		
		_driver.findElement(By.xpath("//div[@class='form-login-signup']/form/div[5]/button")).click();
		Thread.sleep(5000);
		System.out.println("Login Buuton has been clicked");
	}
	
	@Test(priority = 3)
	public void ValidateEmailAlertTest() throws InterruptedException
	{	
		extent.createTest("Validate the Email Alert is Seen");
		
		String text=_driver.findElement(By.xpath("//span[contains(text(),'Please Enter Email Address')]")).getText();
		Assert.assertEquals(text, "Please Enter Email Address");	
		System.out.println("Validation on Email Address has been checked");
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void ValidatePasswordText() throws InterruptedException
	{
		extent.createTest("Validate the Password Alert is Seen");
		
		String text=_driver.findElement(By.xpath("//span[contains(text(),'Please Enter Password.')]")).getText();
		Assert.assertEquals(text, "Please Enter Password.");	
		System.out.println("Validation of password has been verified");
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void LoginToApplication() throws InterruptedException
	{
		extent.createTest("Validate User Able to Login");
		
		String Ausername = "pedro@vesuvio.io";
        String Apassword = "a7rMTZ:!6N9-X2Hj";
        
      _driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Ausername);
      _driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Apassword);  
      _driver.findElement(By.xpath("//div[@class='form-login-signup']/form/div[5]/button")).click();
      
      System.out.println("User has been login Successfully");
      Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void LogOutFromTheApplication() throws InterruptedException
	{
		extent.createTest("Validate the User Able to Logout");
		
		_driver.findElement(By.xpath("//header[@class='header sticky-top d-flex align-items-center justify-content-between px-3 px-md-4 bg-faded-primary']/div/ul/li/a")).click();
		Thread.sleep(5000);
		_driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		System.out.println("User has been logout Successfully");
        Thread.sleep(5000);
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		extent.flush();
		_driver.quit();
	}

}
