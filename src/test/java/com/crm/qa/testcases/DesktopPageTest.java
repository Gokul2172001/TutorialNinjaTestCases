package com.crm.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DesktopPage;

public class DesktopPageTest extends TestBase {
	DesktopPage desktopPage;
	
	public DesktopPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		desktopPage = new DesktopPage();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gokul.elumalai12@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gokul_21122001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Show All Laptops & Notebooks']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Desktops']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Show All Desktops']")).click();
	}
	
	@Test(priority=1)
	public void desktopPageTitleTest() {
		String title = desktopPage.validateDesktopPageTitle();
		Assert.assertEquals(title,"Desktops");
	}
	
	@Test(priority=2)
	public void desktopPageProductCountTest() {
		int count = desktopPage.countProduct();
		Assert.assertEquals(count, 12);
	}
	
	@Test(priority=3) 
	public void desktopPageProductCheckTest() {
		boolean flag=desktopPage.checkProduct();
		Assert.assertEquals(flag, null);
	}
	
	@Test(priority=4)
	public void desktopPageFilterTest() {
		boolean flag=desktopPage.filterCheck();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=5)
	public void desktopPageWishlistTest() {
		String wishlistmsg=desktopPage.wishlistCheck();
		//System.out.println(wishlistmsg);
		Assert.assertEquals(wishlistmsg, "My Wish List");
	}
	
	@Test(priority=6)
	public void desktopPrizeTest() {
		String price=desktopPage.productPrize();
		Assert.assertEquals(price, "Ex Tax: $80.00");
	}
	
	@Test(priority=7) 
	public void desktopViewGridListTest() {
		boolean flag=desktopPage.viewListGrid();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=8)
	public void imgCheckTest() {
		boolean flag=desktopPage.imgCheck();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=9)
	public void relatedProductTest() {
		String related=desktopPage.relatedProduct();
		Assert.assertEquals(related, "Related Products");
	}
	
	@Test(priority=10)
	public void productComparison() {
		String comparison=desktopPage.productCompare();
		Assert.assertEquals(comparison, "Product Comparison");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
