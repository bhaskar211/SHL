package utilities;

import org.openqa.selenium.WebDriver;

import page.CameraPage;
import page.HomePage;
import page.HomePageAmazon;
import page.ProductPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;
	private CameraPage cameraPage;
	private HomePageAmazon homePageAmazon;

	PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePageObject() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public ProductPage getProductPageObject() {
		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}
	public CameraPage getCameraPageObject() {
		return (cameraPage == null) ? cameraPage = new CameraPage(driver) : cameraPage;
	}
	public HomePageAmazon getHomePageAmazonObject() {
		return (homePageAmazon == null) ? homePageAmazon = new HomePageAmazon(driver) : homePageAmazon;
	}
	
}