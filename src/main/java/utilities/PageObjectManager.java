package utilities;

import org.openqa.selenium.WebDriver;

import page.HomePage;
import page.ProductPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;

	PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePageObject() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public ProductPage getProductPageObject() {
		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}
}