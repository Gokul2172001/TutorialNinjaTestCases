package com.crm.qa.pages;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.crm.qa.util.TestUtil;

public class SignUpPage extends TestBase {

	//Page Factory:
	
		@FindBy(xpath="//input[@name='firstname']")
		WebElement firstname;
		
		@FindBy(xpath="//input[@name='lastname']")
		WebElement lastname;
		
		@FindBy(xpath="//input[@name='email']")
		WebElement email;
		
		@FindBy(xpath="//input[@name='telephone']")
		WebElement telephone;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath="//input[@name='confirm']")
		WebElement confirm;
		
		@FindBy(xpath="//input[@name='agree']")
		WebElement agree;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement submit;
		
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")  
 		WebElement emailExist;
		
		String firstname1="Gokul";
		String lastname1="E";
		String email1="gokul.elumalai12@gmail.com";
		String wrongemail1="gokul.elumalai12gmail.com";
		String telephone1="9566554241";
		String password1="Gokul_21122001";
		String confirm1="Gokul_21122001";
		String wrongconfirm1="Gokul21122001";
		
		//Initializing the page objects:
		public SignUpPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateSignUpPageTitle() {
			return driver.getTitle();
		}
		
		public boolean requiredFieldCheck() {
			if(firstname.isDisplayed()) {
				if(lastname.isDisplayed()) {
					if(email.isDisplayed()) {
						if(telephone.isDisplayed()) {
							if(password.isDisplayed()) {
								if(confirm.isDisplayed()) {
									if(agree.isDisplayed()) {
										if(submit.isDisplayed()) {
					
										}
									}
								}
							}
						}
					}
				}
			}
			return true;
		}
		public String validateExistEmailCheck() throws InterruptedException {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			telephone.sendKeys(telephone1);
			password.sendKeys(password1);
			confirm.sendKeys(confirm1);
			agree.click();
			submit.click();
//			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
			Thread.sleep(2000);
			return emailExist.getText();
		}
		
		public void mandatoryFieldCheck() {
			requiredFieldCheck();
		}
		
		public String validateExistPhoneCheck() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys("gokul.elumalai1");
			telephone.sendKeys(telephone1);
			password.sendKeys(password1);
			confirm.sendKeys(confirm1);
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//i[@class='fa-exclamation-circle']")).getText();
		}
		
		public String validatePassword() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			telephone.sendKeys(telephone1);
			password.sendKeys("g");
			confirm.sendKeys("g");
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		}
		
		public String validatePasswordAndConfirm() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			telephone.sendKeys(telephone1);
			password.sendKeys("gokul21122001");
			confirm.sendKeys("Gokul_21122001");
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		}
		
		public boolean validateRadioButtonInSubscribeField() {
			
			return driver.findElement(By.xpath("//input[@type=radio]")).isEnabled();
		}
		
		public String validatePasswordSymbolField() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			telephone.sendKeys(telephone1);
			password.sendKeys("goa");
			confirm.sendKeys("goa");
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		}
		
		public boolean validateContinueField() {
			return submit.isDisplayed();
		}
		
		public boolean validatePrivacyAndPolicy() {
			return driver.findElement(By.xpath("//a[@class='agree']")).isDisplayed();
		}
		
		public String validateBlackField() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			//telephone.sendKeys(telephone1);
			password.sendKeys(password1);
			confirm.sendKeys(confirm1);
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		}
		
		public String validateMandatoryField() {
			firstname.sendKeys(firstname1);
			lastname.sendKeys(lastname1);
			email.sendKeys(email1);
			telephone.sendKeys(telephone1);
			//password.sendKeys(password1);
			//confirm.sendKeys(confirm1);
			agree.click();
			submit.click();
			return driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		}
		
		public boolean validateContinueButton() {
			return submit.isDisplayed();
		}
		

}
