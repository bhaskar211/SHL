package page;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class HomePageAmazon extends BaseClass{
	 WebDriver diver;

	public HomePageAmazon(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy(xpath="//span[text()='Smartphones']")
	WebElement smartPhone;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement enter;
	
	@FindBy(xpath="//span[text()='Sort by:']")
	WebElement select;
	
	@FindBy(xpath="//a[text()='Price: High to Low']")
	WebElement lowToHigh;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement enterToItem;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addTocart;
	String windowHandle = driver.getWindowHandle();
	
	public void searchProuct(String productToSearch) {
		sendValue(search, productToSearch);
		click(enter);
	}
	
	public void selectCategory()
	{
		click(smartPhone);
	}
	
	public void sort()
	{
		click(select);
		click(lowToHigh);
	}
	public void getitem()
	{
		click(enterToItem);
		ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
	    System.out.println(tabs.size());
	    driver.switchTo().window(tabs.get(1)); 
		click(addTocart);
	}
}
