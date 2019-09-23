package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;
import utilities.Constants;

public class HomePage extends BaseClass {

	private WebDriver driver;


	@FindBy(xpath = "//button[text()='✕']")
	private WebElement quit;

	@FindBy(xpath = "//input[@title=\"Search for products, brands and more\"]")
	private WebElement search;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement enter;
	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	WebElement electronics;
	
	@FindBy(xpath="//*[text()='Compact & Bridge Cameras']")
	WebElement clickTo;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public void closeLoginWindow() {
		click(quit);
	}

	public void clickOnSearchButton() {
		click(search);
	}

	public void searchProuct(String productToSearch) {
		sendValue(search, productToSearch);
		click(enter);
	}
	
	public void hoverAndclick()
	{
		hover(electronics,driver);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compact & Bridge Cameras']")));
		click(clickTo);
		
	}
}
