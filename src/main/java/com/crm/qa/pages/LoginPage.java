package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory OR:
		@FindBy(xpath="//input[@name='email']")
		WebElement username;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement login;
		
		@FindBy(xpath="//a[@class='list-group-item'][1]")
		WebElement register;
		
		@FindBy(xpath="//a[contains(text(),'Your Store')]")
		WebElement YourStore;
		
		@FindBy(xpath="(//a[normalize-space()='Forgotten Password'])[1]")
		WebElement ForgotPassword;
		
		//Initializing the page objects:
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public String validateLogin() {
			username.sendKeys("gokul.elumalai12@gmail.com");
			password.sendKeys("Gokul_21122001");
			login.click();
			
			return driver.getTitle();
			
			//return new HomePage();
		}
		
		public String validateLoginWithoutUsernameandPassword() {
			login.click();
			return driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			
		}
		
		public String validateLoginTestWithWrongCredentials() {
			username.sendKeys("gokul222");
			password.sendKeys("gielaei");
			login.click();
			return driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		}
		
		public String validateForgotPassword() {
			ForgotPassword.click();
			return driver.findElement(By.xpath("//h1[normalize-space()='Forgot Your Password?']")).getText();
		}
		
		public String validateChangePassword() {
			ForgotPassword.click();
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hhade@gmail.com");
			login.click();
			return driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		}

}
