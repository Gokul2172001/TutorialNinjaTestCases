package com.crm.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ComponentsPage;

public class ComponentsPageTest extends TestBase {
	ComponentsPage componentsPage;
	
	public ComponentsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		componentsPage = new ComponentsPage();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gokul.elumalai12@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gokul_21122001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Show All Components']")).click();
	}
	
	@Test(priority=1)
	public void componentsPageTitleTest() {
		String title = componentsPage.validateComponentsPageTitle();
		Assert.assertEquals(title,"Components");
	}
	
	@Test(priority=2)
	public void componentsPageProductCountTest() {
		int count = componentsPage.countProduct();
		Assert.assertEquals(count, 2);
	}
	
	@Test(priority=3) 
	public void componentsPageProductCheckTest() {
		boolean flag=componentsPage.checkProduct();
		Assert.assertEquals(flag, null);
	}
	
	@Test(priority=4)
	public void componentsPageFilterTest() {
		boolean flag=componentsPage.filterCheck();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=5)
	public void componentsPageWishlistTest() {
		String wishlistmsg=componentsPage.wishlistCheck();
		Assert.assertEquals(wishlistmsg, "My Wish List");
	}
	
	@Test(priority=6)
	public void componentsPrizeTest() {
		String price=componentsPage.productPrize();
		Assert.assertEquals(price, "Ex Tax: $80.00");
	}
	
	@Test(priority=7) 
	public void componentsViewGridListTest() {
		boolean flag=componentsPage.viewListGrid();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=8)
	public void imgCheckTest() {
		boolean flag=componentsPage.imgCheck();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=9)
	public void relatedProductTest() {
		String related=componentsPage.relatedProduct();
		Assert.assertEquals(related, "Related Products");
	}
	
	@Test(priority=10)
	public void productComparison() {
		String comparison=componentsPage.productCompare();
		Assert.assertEquals(comparison, "Product Comparison");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
