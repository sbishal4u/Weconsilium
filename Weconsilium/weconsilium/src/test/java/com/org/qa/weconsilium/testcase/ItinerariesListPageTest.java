package com.org.qa.weconsilium.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.org.weconsilium.qa.pageobject.LoginPage;
import com.org.weconsilium.qa.utils.TestUtils;

public class ItinerariesListPageTest 
{
	LoginPage login;
	public static WebDriver _driver;
	JavascriptExecutor executor;
	
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
		spark=new ExtentSparkReporter("ItinerariesListPageTest.html");
		extent.attachReporter(spark);
		
		
		
		//_driver = new ChromeDriver();
		executor = (JavascriptExecutor)_driver;
		login =new LoginPage(_driver);
		_driver.manage().window().maximize();
		_driver.get("https://weconsilium-qa.azurewebsites.net/user/login");
		_driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void LoginToApplication() throws InterruptedException
	{
		extent.createTest("User Logged in Successfully");
		
		String Ausername = "pedro@vesuvio.io";
        String Apassword = "a7rMTZ:!6N9-X2Hj";
        
      _driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Ausername);
      _driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Apassword);  
      _driver.findElement(By.xpath("//div[@class='form-login-signup']/form/div[5]/button")).click();
      
      System.out.println("User has been login Successfully");
      Thread.sleep(5000);
	}
	
	
	@Test(priority = 2)
	public void CheckCancelButton() throws InterruptedException
	{
		extent.createTest("CheckCancelButton");
		
		System.out.println("A Cancel button is working");
		_driver.findElement(By.xpath("//span[contains(text(),'Create Itinerary')]")).click();
		Thread.sleep(5000);
		_driver.findElement(By.xpath("//div[@class='row justify-content-between  align-items-center']/div[2]/a[1]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void clickEditButton() throws InterruptedException
	{
		extent.createTest("clickEditButton");
		
		_driver.findElement(By.xpath("//div[@class='content-area main']/section/div[2]/form/div/div[2]/table/tbody/tr[2]/td[8]/div/a[1]")).click();
		Thread.sleep(3000);
		_driver.findElement(By.xpath("//div[@class='row justify-content-between  align-items-center']/div[2]/a[1]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void ClickDeteleButton() throws InterruptedException
	{
		extent.createTest("ClickDeteleButton");
		
		System.out.println("Itineraries has been deleted");
		_driver.findElement(By.xpath("//div[@class='content-area main']/section/div[2]/form/div/div[2]/table/tbody/tr[2]/td[8]/div/a[2]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void SwithToAlert() throws InterruptedException
	{
		extent.createTest("SwithToAlert");
		
		System.out.println("A Delete Button is clicked");
		_driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void TearDown()
	{
		extent.flush();
		_driver.quit();
	}
	
	
	
	
	

}
