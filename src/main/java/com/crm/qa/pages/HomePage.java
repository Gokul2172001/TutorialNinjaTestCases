package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Your Store')]")
	WebElement labelLink;
	
	@FindBy(xpath="//a[contains(text(),'Tablets')]")
	WebElement tabletLink;
	
	@FindBy(xpath="//a[contains(text(),'Software')]")
	WebElement softwareLink;
	
	@FindBy(xpath="//a[contains(text(),'Cameras')]")
	WebElement camerasLink;
	
	//Initializing the page Objects:
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public TabletsPage clickOnTabletsLink() {
		tabletLink.click();
		return new TabletsPage();
	}
	
	public SoftwaresPage clickOnSoftwaresLink() {
		softwareLink.click();
		return new SoftwaresPage();
	}
	
	public CamerasPage clickOnCamerasLink() {
		camerasLink.click();
		return new CamerasPage();
	}

}
