package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	
	SignUpPage signUpPage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
	}
	
	@Test(priority=1)
	public void signUpPageTitleTest() {
		String title = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(title,"Register Account","Title is not we expected");
	}
	
	@Test(priority=2)
	public void fieldCheck() {
		boolean field = signUpPage.requiredFieldCheck();
		Assert.assertTrue(field);
	}
	
	@Test(priority=3)
	public void existEmailCheck() throws InterruptedException {
		String emailexist = signUpPage.validateExistEmailCheck();
		Assert.assertEquals(emailexist, "Warning: E-Mail Address is already registered!","Warning doesn't exist - Reported as bug...");
	}
	
	@Test(priority=4)
	public void mandatoryCheck() {
		boolean field = signUpPage.requiredFieldCheck();
		Assert.assertTrue(field);
	}
	
	@Test(priority=5)
	public void varifyPhoneCheck() {
		String mobileExist=signUpPage.validateExistPhoneCheck();
		Assert.assertEquals(mobileExist, "Warning: Telephone is already registered!","Warning doesn't exist - Reported as bug...");
	}
	
	@Test(priority=6)
	public void verifyPasswordCheck() {
		String checkPassword=signUpPage.validatePassword();
		Assert.assertEquals(checkPassword, "Password must be between 4 and 20 characters!", "Bug founded");
	}
	
	@Test(priority=7)
	public void verifyPasswordAndConfirmCheck() {
		String checkPasswordAndConfirm=signUpPage.validatePasswordAndConfirm();
		Assert.assertEquals(checkPasswordAndConfirm, "Password confirmation does not match password!", "Bug founded");
	}
	
	@Test(priority=8)
	public void verifyPasswordSymbolCheck() {
		String checkPasswordSymbol=signUpPage.validatePasswordSymbolField();
		Assert.assertEquals(checkPasswordSymbol, "Password must be between 4 and 20 characters!", "Bug founded");
	}
	
	@Test(priority=9)
	public void verifyContinueButtonCheck() {
		boolean flag=signUpPage.validateContinueField();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=10) 
	public void verifyPrivacyAndPolicyCheck() {
		boolean flag=signUpPage.validatePrivacyAndPolicy();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=11)
	public void verifyBlankFieldCheck() {
		String blankMessage=signUpPage.validateBlackField();
		Assert.assertEquals(blankMessage, "Telephone must be between 3 and 32 characters!");
	}
	
	@Test(priority=12)
	public void verifyMandatoryFieldCheck() {
		String mandatoryMessage=signUpPage.validateMandatoryField();
		Assert.assertEquals(mandatoryMessage, "Password must be between 4 and 20 characters!");
	}
	
	@Test(priority=13)
	public void verifySubmitButtonCheck() {
		boolean flag=signUpPage.validateContinueButton();
		Assert.assertEquals(flag, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
