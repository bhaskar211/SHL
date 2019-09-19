package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToUrl(String url) {
		driver.get(url);
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
}
