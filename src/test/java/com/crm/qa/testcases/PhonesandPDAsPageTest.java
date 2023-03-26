package com.crm.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CamerasPage;

public class CamerasPageTest extends TestBase {
	CamerasPage camerasPage;
	
	public CamerasPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		camerasPage = new CamerasPage();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gokul.elumalai12@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gokul_21122001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//li[7]")).click();
	}
	
	@Test(priority=1)
	public void cameraPageTitleTest() {
		String title = camerasPage.validateCamerasPageTitle();
		Assert.assertEquals(title,"Cameras");
	}
	
	@Test(priority=2)
	public void cameraPageProductCountTest() {
		int count = camerasPage.countProduct();
		Assert.assertEquals(count, 2);
	}
	
	@Test(priority=3) 
	public void cameraPageProductCheckTest() {
		boolean flag=camerasPage.checkProduct();
		Assert.assertEquals(flag, null);
	}
	
	@Test(priority=4)
	public void cameraPageFilterTest() {
		boolean flag=camerasPage.filterCheck();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=5)
	public void cameraPageWishlistTest() {
		String wishlistmsg=camerasPage.wishlistCheck();
		//System.out.println(wishlistmsg);
		Assert.assertEquals(wishlistmsg, "My Wish List");
	}
	
	@Test(priority=6)
	public void cameraPrizeTest() {
		String price=camerasPage.productPrize();
		Assert.assertEquals(price, "Ex Tax: $80.00");
	}
	
	@Test(priority=7) 
	public void cameraViewGridListTest() {
		boolean flag=camerasPage.viewListGrid();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=8)
	public void imgCheckTest() {
		boolean flag=camerasPage.imgCheck();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=9)
	public void relatedProductTest() {
		String related=camerasPage.relatedProduct();
		Assert.assertEquals(related, "Related Products");
	}
	
	@Test(priority=10)
	public void productComparison() {
		String comparison=camerasPage.productCompare();
		Assert.assertEquals(comparison, "Product Comparison");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
