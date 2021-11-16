package com.org.weconsilium.qa.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.org.weconsilium.qa.utils.DropDownHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ItinerariePage 
{
	WebDriver driver;
	
	
	public ItinerariePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(xpath ="//span[contains(text(),'Create Itinerary')]")
	WebElement ItineryButton;
	
	@FindBy(xpath ="//input[@name='ItineraryName']")
	WebElement textItineryInput;
	
	@FindBy(xpath ="//input[@name='StartDate']")
	WebElement itineryStartDate;
	
	@FindBy(xpath ="//input[@name='EndDate']")
	WebElement itineryEndDate;
	
	@FindBy(xpath ="//span[contains(text(),'Details')]")
	WebElement ItinerayDetailTab;
	
	@FindBy(xpath ="//input[@name='CategoryOne']")
	WebElement Itinerycategory;
	
	@FindBy(xpath ="//input[@name='InstructionOne']")
	WebElement ItineryInstruction;
	
	@FindBy(xpath ="//a[@id='btnBMSTeam']")
	WebElement BMSTeamTab;
	
	@FindBy(xpath ="//div[@id='45']/select")
	WebElement BMSDropDown;
	
	@FindBy(xpath ="//div[@id='45']/select/option[2]")
	WebElement BMSDropDownText;
	
	@FindBy(xpath ="//nav[@id='navbar-example2']/ul/li[4]")
	WebElement GuestProducerTab;
	
	@FindBy(xpath ="//div[@id='1046']/select")
	WebElement GuestProdDropDown;
	
	@FindBy(xpath ="//div[@id='1046']/select/option[2]")
	WebElement GuestProdText;
	

	@FindBy(xpath ="//div[@id='1069']/select")
	WebElement ItineryGuesInsuredTab;
	
	@FindBy(xpath ="//div[@id='1069']/select/option[2]")
	WebElement ItineryGuesInsuredTabText;
	
	@FindBy(xpath ="//div[@id='1054']/select")
	WebElement ProducerName;
	
	@FindBy(xpath ="//div[@id='1054']/select/option[2]")
	WebElement ProducerNametext;
	
	@FindBy(xpath ="//span[contains(text(),'Guest Insureds')]")
	WebElement GuestInsuredTab;
	
	@FindBy(xpath ="//div[@id='1069']/select")
	WebElement GuestInsuredDD;
	
	@FindBy(xpath ="//div[@id='1069']/select/option[2]")
	WebElement GuestInsuredDDText;
	
	@FindBy(xpath ="//div[@id='1076']/select")
	WebElement GuestInsureName;
	
	@FindBy(xpath ="//div[@id='1076']/select/option[2]")
	WebElement GuestInsureNametext;
	
	@FindBy(xpath ="//div[@class='col-7 text-end']/a[2]")
	WebElement saveButton;
	
	@FindBy(xpath ="//div[@id='1181']/div/img")
	WebElement uploadImage;
	
	@FindBy(xpath ="//ul[@class='nav flex-column pt-4 sidebar-nav']/li[1]/a")
	WebElement ItinerariesTab;
	
	
	
	/*****************Edit and Delete**********************/
	@FindBy(xpath ="//div[@class='content-area main']/section/div[2]/form/div/div[2]/table/tbody/tr[2]/td[8]/div/a[1]")
	WebElement EditButton;
	
	@FindBy(xpath ="//div[@class='content-area main']/section/div[2]/form/div/div[2]/table/tbody/tr[2]/td[8]/div/a[2]")
	WebElement DeleteButton;
	
	@FindBy(xpath ="//div[@class='col-7 text-end']/a[1]")
	WebElement CancelButton;
	
	public void ClickItineryButton()
	{
		ItineryButton.click();
	}
	
	public void ValidateChooseName(String Aname)
	{
		textItineryInput.sendKeys(Aname);
	}
	
	
	
	public void EnterStartDate() throws InterruptedException
	{
		itineryStartDate.click();
		itineryStartDate.sendKeys("01/11/2021");
		
		itineryEndDate.click();
		itineryEndDate.sendKeys("06/11/2021");
		textItineryInput.click();
		Thread.sleep(3000);
	}
	
	public void NavigateToDetails(String aCat,String aInstt) throws InterruptedException
	{
		ItinerayDetailTab.click();
		Itinerycategory.sendKeys(aCat);
		ItineryInstruction.sendKeys(aCat,aInstt);
		Thread.sleep(3000);
	}
	
	public void NavigateToBMSTeam() throws InterruptedException
	{
		BMSTeamTab.click();
		Thread.sleep(3000);
		
		BMSDropDown.click();
		Thread.sleep(3000);
		DropDownHelper dd=new DropDownHelper();
		dd.HandlingDropDown(BMSDropDown, BMSDropDownText.getText());
		BMSTeamTab.click();
		Thread.sleep(3000);
	}																				
	
	public void NavigateGuestProducer() throws InterruptedException
	{
		GuestProducerTab.click();
		Thread.sleep(3000);
		GuestProdDropDown.click();
		Thread.sleep(3000);
		DropDownHelper dd=new DropDownHelper();
		dd.HandlingDropDown(GuestProdDropDown, GuestProdText.getText());
		GuestProducerTab.click();
		Thread.sleep(3000);
	}
	
	public void NavigateToGuestProducerName() throws InterruptedException
	{
		ProducerName.click();
		DropDownHelper dd=new DropDownHelper();
		dd.HandlingDropDown(ProducerName, ProducerNametext.getText());
		ProducerName.click();
		Thread.sleep(3000);
	}
	
	public void GuestInsuredTab() throws InterruptedException
	{
		GuestInsuredTab.click();
		Thread.sleep(3000);
		GuestInsuredDD.click();
		
		DropDownHelper dd=new DropDownHelper();
		dd.HandlingDropDown(GuestInsuredDD, GuestInsuredDDText.getText());
		GuestInsuredDD.click();
		Thread.sleep(3000);
	}
	
	public void NavigateGuestName() throws InterruptedException
	{
		GuestInsureName.click();
		DropDownHelper dd=new DropDownHelper();
		dd.HandlingDropDown(GuestInsureName, GuestInsureNametext.getText());
		GuestInsureName.click();
		Thread.sleep(3000);
		saveButton.click();
		
		Thread.sleep(5000);
	}
	
	public void UploadImage() throws AWTException, InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", uploadImage);
		
		Robot robot = new Robot();
		//uploadImage.click();
		StringSelection ss = new StringSelection("D:\\VesuvioAutomation\\AutomationJava\\Weconsilium\\weconsilium\\Image\\Screenshot_2.png");
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
	     Thread.sleep(3000);
	     saveButton.click();
	     
	     Thread.sleep(3000);
	     ItinerariesTab.click();
	}
	
	public void ClickEditButton() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditButton);
		//EditButton.click();
		Thread.sleep(5000);
		CancelButton.click();
	}
	
	public void ClickDelete() throws InterruptedException
	{
		Thread.sleep(5000);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DeleteButton);
		
		//DeleteButton.click();
		Thread.sleep(5000);
		CancelButton.click();
	}
	
	
	
	
	
	
	

	
	

}
