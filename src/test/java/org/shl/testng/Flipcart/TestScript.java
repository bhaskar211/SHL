package org.shl.testng.Flipcart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import page.HomePage;
import page.ProductPage;
import utilities.Constants;
import utilities.Launcher;

public class TestScript extends Launcher{
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
		homePage = pageObjectManager.getHomePageObject();
	}

	@Test
	public void login() {
		homePage.goToUrl(Constants.URL);
		homePage.closeLoginWindow();
		homePage.clickOnSearchButton();
		homePage.searchProuct(Constants.PRODUCT);
		productPage = pageObjectManager.getProductPageObject();
		productPage.view();
	}
}
