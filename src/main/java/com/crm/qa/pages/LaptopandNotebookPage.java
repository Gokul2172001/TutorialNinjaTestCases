package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class CamerasPage extends TestBase {
	
	@FindBy(xpath="//input[@type='radio']")
	WebElement radio;
	
	@FindBy(xpath="//input[@name='option[223][]']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@name='option[208]']")
	WebElement text;
	
	@FindBy(xpath="//select[@name='option[217]']")
	WebElement select;
	
	@FindBy(xpath="//div[@class='form-group required has-error][4]'")
	WebElement textarea;
	
	@FindBy(xpath="//input[@name='option[219]']")
	WebElement date;
	
	@FindBy(xpath="//input[@name='option[221]']")
	WebElement time;
	
	@FindBy(xpath="//input[@name='option[220]']")
	WebElement dateAndTime;
	
	@FindBy(xpath="//input[@name='quantity']")
	WebElement qty;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//a[normalize-space()='Canon EOS 5D']")
	WebElement camera1;
	
	@FindBy(xpath="//img[@title='Nikon D300']")
	WebElement camera2;
	
	@FindBy(xpath="//p[@class='price']")
	WebElement camera1prize;
	
	@FindBy(xpath="//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//p[2]")
	WebElement camera2prize;
	
	public String validateCamerasPageTitle() {
		return driver.getTitle();
	}
	
	public int countProduct() {
		List<WebElement> myListToCheck=driver.findElements(By.xpath("//div[@class='product-thumb']"));
		if(myListToCheck.size()>0){
			return myListToCheck.size();
		}
		else{
			return 0;
		}
	}
	
	public boolean checkProduct() {
	if(camera1.isDisplayed())
		if(camera1prize.isDisplayed())
				if(camera2.isDisplayed())
					if(camera2prize.isDisplayed()) {
						return true;
					}
					else {
						return false;
					}
						
		return true;
	}
	
	public boolean filterCheck() {
		driver.findElement(By.xpath("//select[@id='input-sort']//option[2]")).click();
		return driver.findElement(By.xpath("//select[@id='input-sort']//option[2]")).isSelected();
	}
	
	public String wishlistCheck() {
		driver.findElement(By.xpath("//span[normalize-space()='Wish List (0)']")).click();
		return driver.findElement(By.xpath("//div[@class='col-sm-9']//h2")).getText();
	}
	
	public String productPrize() {
		return driver.findElement(By.xpath("//p[@class='price']//span[@class='price-tax']")).getText();
	}
	
	public boolean viewListGrid() {
		driver.findElement(By.xpath("//button[@id='list-view']")).click();
		return driver.findElement(By.xpath("//button[@id='list-view']")).isEnabled();
	}
	
	public boolean imgCheck() {
		//driver.findElement(By.xpath("//img[@class='img-responsive']"));
		List<WebElement> myListToCheck=driver.findElements(By.xpath("//img[@class='img-responsive']"));
		if(myListToCheck.size()==3){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String relatedProduct() {
		return driver.findElement(By.xpath("//h3[contains(text(),'Related Products')]")).getText();
	}
	
	public String productCompare() {
		driver.findElement(By.xpath("//a[@id='compare-total']")).click();
		return driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	}
}
