package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage	;
	//HomePage homePage ;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Account Login");
	}
	
	@Test(priority=2)
	public void verifyLogin() {
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String login=loginPage.validateLogin();
		Assert.assertEquals(login, "My Account", "Test Passed");
		
	}
	
	@Test(priority=3)
	public void loginTestWithoutLoginAndPassword() {
		String loginError=loginPage.validateLoginWithoutUsernameandPassword();
		Assert.assertEquals(loginError, "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	@Test(priority=4)
	public void loginTestWithWrongCredentials() {
		String loginErrorMsg=loginPage.validateLoginTestWithWrongCredentials();
		Assert.assertEquals(loginErrorMsg, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test(priority=5)
	public void forgotPasswordTest() {
		String forgotMsg=loginPage.validateForgotPassword();
		Assert.assertEquals(forgotMsg, "Forgot Your Password?");
	}
	
	@Test(priority=6)
	public void changePassword() {
		String change=loginPage.validateChangePassword();
		Assert.assertEquals(change, "An email with confirmation link has been sent your email address");
	}
//	@Test(priority=7)
//	
//	@Test(priority=8)
//	
//	@Test(priority=9)
//	
//	@Test(priority=10)
//	
//	@Test(priority=11)
//	
//	@Test(priority=12)
//	
//	@Test(priority=13)
//	
//	@Test(priority=14)
//	
//	@Test(priority=15)
//	
//	@Test(priority=16)
//	
//	@Test(priority=17)
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
