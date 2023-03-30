package com.crm.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LaptopandNotebookPage;

public class LaptopandNotebookPageTest extends TestBase {
	LaptopandNotebookPage laptopandNotebookPage;
	public LaptopandNotebookPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		laptopandNotebookPage = new LaptopandNotebookPage();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gokul.elumalai12@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gokul_21122001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Show All Laptops & Notebooks']")).click();
	}
	
	@Test(priority=1)
	public void LaptopandNotebookPageTitleTest() {
		String title = laptopandNotebookPage.validateLaptopandNotebookPageTitle();
		Assert.assertEquals(title,"Laptops & Notebooks");
	}
	
	@Test(priority=2)
	public void laptopandNotebookPageProductCountTest() {
		int count = laptopandNotebookPage.countProduct();
		Assert.assertEquals(count, 2);
	}
	
	@Test(priority=3) 
	public void laptopandNotebookPageProductCheckTest() {
		boolean flag=laptopandNotebookPage.checkProduct();
		Assert.assertEquals(flag, null);
	}
	
	@Test(priority=4)
	public void laptopandNotebookPageFilterTest() {
		boolean flag=laptopandNotebookPage.filterCheck();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=5)
	public void laptopandNotebookPageWishlistTest() {
		String wishlistmsg=laptopandNotebookPage.wishlistCheck();
		//System.out.println(wishlistmsg);
		Assert.assertEquals(wishlistmsg, "My Wish List");
	}
	
	@Test(priority=6)
	public void laptopandNotebookPrizeTest() {
		String price=laptopandNotebookPage.productPrize();
		Assert.assertEquals(price, "Ex Tax: $80.00");
	}
	
	@Test(priority=7) 
	public void laptopandNotebookViewGridListTest() {
		boolean flag=laptopandNotebookPage.viewListGrid();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=8)
	public void imgCheckTest() {
		boolean flag=laptopandNotebookPage.imgCheck();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=9)
	public void relatedProductTest() {
		String related=laptopandNotebookPage.relatedProduct();
		Assert.assertEquals(related, "Related Products");
	}
	
	@Test(priority=10)
	public void productComparison() {
		String comparison=laptopandNotebookPage.productCompare();
		Assert.assertEquals(comparison, "Product Comparison");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
