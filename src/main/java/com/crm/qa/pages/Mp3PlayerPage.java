package com.crm.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.crm.qa.base.TestBase;

public class Mp3PlayerPage extends TestBase {
	
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
	
	@FindBy(xpath="//a[normalize-space()='iPod Classic']")
	WebElement ipod1;
	
	@FindBy(xpath="//a[normalize-space()='iPod Nano']")
	WebElement ipod2;
	
	@FindBy(xpath="//a[normalize-space()='ipod Shuffle']")
	WebElement ipod3;
	
	@FindBy(xpath="//a[normalize-space()='ipod Touch']")
	WebElement ipod4;
	
	@FindBy(xpath="//p[@class='price']")
	WebElement ipod1prize;
	
	@FindBy(xpath="//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//p[2]")
	WebElement ipod2prize;
	
	@FindBy(xpath="//p[@class='price']")
	WebElement ipod3prize;
	
	@FindBy(xpath="//body//div[@id='product-category']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]//div[1]//p[2]")
	WebElement ipod4prize;
	
	public String validateMp3PlayerPageTitle() {
		return driver.getTitle();
	}
	
	public int countProduct() {
		List<WebElement> myListToCheck=driver.findElements(By.xpath("//div[@class='product-thumb']"));
		if(myListToCheck.size()>0){
			return myListToCheck.size();
		}else{
			return 0;
		}
	}
	
	public boolean checkProduct() {
	if(ipod1.isDisplayed())
		if(ipod1prize.isDisplayed())
				if(ipod2.isDisplayed())
					if(ipod2prize.isDisplayed())
						if(ipod3.isDisplayed())
							if(ipod3prize.isDisplayed())
								if(ipod4.isDisplayed())	
									if(ipod4prize.isDisplayed()) {
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
		List<WebElement> myListToCheck=driver.findElements(By.xpath("//img[@class='img-responsive']"));
		if(myListToCheck.size()==3){
			return true;
		}else{
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
