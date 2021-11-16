package com.org.qa.weconsilium.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import com.org.weconsilium.qa.pageobject.ItinerariePage;
import com.org.weconsilium.qa.pageobject.LoginPage;
import com.org.weconsilium.qa.utils.DropDownHelper;
import com.org.weconsilium.qa.utils.TestUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class ItinerariePageTest 
{
	Faker faker;
	Robot robot;
	LoginPage login;
	ItinerariePage itinery;
	DropDownHelper dd;
	public static WebDriver _driver;
	static ExtentReports extent;
	ExtentSparkReporter spark;
	
	@BeforeClass
	public void SetUp() throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--headless");
		_driver = new ChromeDriver(opt);
		
		
		extent =new ExtentReports();
		spark=new ExtentSparkReporter("ItinerariePageTest.html");
		extent.attachReporter(spark);
		
		//_driver = new ChromeDriver();
		login =new LoginPage(_driver);
		itinery=new ItinerariePage(_driver);
		dd=new DropDownHelper();
		robot=new Robot();
		
		faker = new Faker();
		_driver.manage().window().maximize();
		_driver.get("https://weconsilium-qa.azurewebsites.net/user/login");
		_driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void LoginToApplicationTest() throws InterruptedException
	{
		extent.createTest("User Logged in Successfully");
		
		String Ausername = "pedro@vesuvio.io";
        String Apassword = "a7rMTZ:!6N9-X2Hj";
        
      _driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Ausername);
      _driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Apassword);  
      _driver.findElement(By.xpath("//div[@class='form-login-signup']/form/div[5]/button")).click();
      
      System.out.println("User has been logged in Successfully");
      Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void ClickItineryButtonTest() throws InterruptedException
	{
		extent.createTest("User clicked Itinery Button Successfully");
		
		System.out.println("A Create Itinerary Button has been clicked");
		_driver.findElement(By.xpath("//div[@class='d-flex align-items-center mb-4']/div[2]/a")).click();
		Thread.sleep(3000);
		_driver.findElement(By.xpath("//ul[@class='nav flex-column pt-4']/li[1]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void NavigateToChooseDetailTab() throws InterruptedException
	{
		extent.createTest("User clicked Choose Detail Tab Successfully");
		
		System.out.println("Detail of Choose Name has been inserted");
		
		_driver.findElement(By.xpath("//input[@name='ItineraryName']")).clear();
		_driver.findElement(By.xpath("//input[@name='ItineraryName']")).click();
		Thread.sleep(3000);	
		_driver.findElement(By.xpath("//input[@name='ItineraryName']")).sendKeys(faker.name().firstName());
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 4)
	public void StartDate() throws InterruptedException
	{
		extent.createTest("Start and End Date Entered");
		
		System.out.println("A Start and End Date has been inserted");
		
		_driver.findElement(By.xpath("//input[@name='StartDate']")).click();
		_driver.findElement(By.xpath("//input[@name='StartDate']")).sendKeys("01/11/2021");
		
		_driver.findElement(By.xpath("//input[@name='EndDate']")).click();
		_driver.findElement(By.xpath("//input[@name='EndDate']")).sendKeys("01/11/2021");
		
		_driver.findElement(By.xpath("//input[@name='ItineraryName']")).click();	
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 5)
	public void UploadThImage() throws InterruptedException
	{
		extent.createTest("Upload Functionality is working");
		
		System.out.println("An upload document Functionality has worked");
		
		_driver.findElement(By.xpath("//div[@id='1215']")).click();
		StringSelection ss = new StringSelection("D:\\VesuvioJavaAutomation\\Weconsilium\\weconsilium\\TestData\\Ku-1.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     
	     
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     Thread.sleep(3000);
	     
	     robot.keyPress(KeyEvent.VK_V);
	     Thread.sleep(3000);
	     
	     robot.keyRelease(KeyEvent.VK_V);
	     
	     
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     Thread.sleep(5000);	
	}
		
	@Test(priority = 6)
	public void NavigateToDetails() throws InterruptedException
	{
		extent.createTest("Detail Side tab is clicked");
		
		System.out.println("Navigate to Detail Tab");
		String f1 = faker.name().firstName();
		String f2 = faker.name().lastName();
		
		_driver.findElement(By.xpath("//span[contains(text(),'Details')]")).click();
		Thread.sleep(3000);	
		_driver.findElement(By.xpath("//input[@name='CategoryOne']")).sendKeys(f1);
		_driver.findElement(By.xpath("//input[@name='InstructionOne']")).sendKeys(f2);
		Thread.sleep(5000);
	}
	
	@Test(priority = 7)
	public void NavigateToBMSTeam() throws InterruptedException
	{
		extent.createTest("Navigate to Side Tab");
		
		System.out.println("Navigate to BMS Tab");
		_driver.findElement(By.xpath("//a[@id='btnBMSTeam']")).click();
		Thread.sleep(3000);	
	}
	
	@Test(priority = 8)
	public void NavigateBMSDropDown() throws InterruptedException
	{
		extent.createTest("Navigate to BMS Drop Down");
		
		System.out.println("Navigate to BMS DropDown");
		
		_driver.findElement(By.xpath("//div[@id='45']/select")).click();
		Thread.sleep(3000);
		
		WebElement BMSDropDown=_driver.findElement(By.xpath("//div[@id='45']/select"));
		WebElement BMSDropDownText=_driver.findElement(By.xpath("//div[@id='45']/select/option[2]"));
		dd.HandlingDropDown(BMSDropDown, BMSDropDownText.getText());
		Thread.sleep(5000);	
		
	}
	
	@Test(priority = 9)
	public void NavigateToGuestproducer() throws InterruptedException
	{
		extent.createTest("NavigateToGuestproducer");
		
		System.out.println("Navigate to Guest Producer DropDown");
		
		_driver.findElement(By.xpath("//a[@id='btnGuestProducer']")).click();
		Thread.sleep(3000);
		
		WebElement GuestProdDropDown=_driver.findElement(By.xpath("//div[@id='1046']/select"));
		WebElement GuestProdText=_driver.findElement(By.xpath("//div[@id='1046']/select/option[2]"));
		
		dd.HandlingDropDown(GuestProdDropDown, GuestProdText.getText());
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 10)
	public void NavigateToGuestProducerName() throws InterruptedException
	{
		extent.createTest("NavigateToGuestProducerName");
		System.out.println("Navigate to Guest Producer Name");
		
		WebElement ele=_driver.findElement(By.xpath("//div[@id='1054']/select"));
		ele.click();
		
		WebElement ele1=_driver.findElement(By.xpath("//div[@id='1054']/select/option[2]"));
		
		Thread.sleep(3000);
		dd.HandlingDropDown(ele, ele1.getText());
		Thread.sleep(3000);
		
		_driver.findElement(By.xpath("//span[contains(text(),'Guest Insureds')]")).click();
		Thread.sleep(5000);
		
		
	}
	
	
	@Test(priority = 11)
	public void NavigateGuestInsuredTab() throws InterruptedException
	{
		extent.createTest("NavigateGuestInsuredTab");
		
		System.out.println("Navigate to Guest Insured Tab");
		_driver.findElement(By.xpath("//span[contains(text(),'Guest Insureds')]")).click();
		Thread.sleep(3000);
		
		
		WebElement GuestInsuredTab=_driver.findElement(By.xpath("//div[@id='1069']/select"));
		GuestInsuredTab.click();
		WebElement GuestInsuredDDText=_driver.findElement(By.xpath("//div[@id='1069']/select/option[2]"));
		dd.HandlingDropDown(GuestInsuredTab, GuestInsuredDDText.getText());
		
		Thread.sleep(5000);
	}
	
	@Test(priority = 12)
	public void NavigateGuestName() throws InterruptedException
	{
		extent.createTest("NavigateGuestName");
		
		System.out.println("Navigate to Guest Insured Name");

		WebElement GuestInsureName=_driver.findElement(By.xpath("//div[@id='1076']/select"));
		WebElement GuestInsureNametext=_driver.findElement(By.xpath("//div[@id='1076']/select/option[2]"));
		
		dd.HandlingDropDown(GuestInsureName, GuestInsureNametext.getText());
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 13)
	public void ClickSaveButton()
	{
		extent.createTest("Save Button Clicked");
		
		System.out.println("Click Save Button");
		_driver.findElement(By.xpath("//div[@class='col-7 text-end']/a[2]")).click();
	}
	
	@AfterClass
	public void TearDoWn()
	{
		extent.flush();
		_driver.quit();
	}
	
	
	
	
	
	
	
	


}
