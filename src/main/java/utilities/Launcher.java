package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import page.CameraPage;
import page.HomePage;
import page.HomePageAmazon;
import page.ProductPage;
import utilities.Constants;
import utilities.PageObjectManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launcher {
	public WebDriver driver;
	protected PageObjectManager pageObjectManager;
	protected HomePage homePage;
	protected ProductPage productPage;
	protected CameraPage cameraPage;
	protected HomePageAmazon homePageAmazon;

	//@BeforeClass
	public void launchBrowser()  {
		switch (Constants.BROWSER) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IExplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			try {
				throw new Exception("pass valid browser name");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		pageObjectManager = new PageObjectManager(driver);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}