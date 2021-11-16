package com.org.weconsilium.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper
{
	public WebDriver driver;
	public void HandlingDropDown(WebElement element, String visibleValue)
	{
		Select dropdown = new Select(element);  
		dropdown.selectByVisibleText(visibleValue);  
	}

}
