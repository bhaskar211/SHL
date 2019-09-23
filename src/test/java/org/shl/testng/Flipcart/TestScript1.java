package org.shl.testng.Flipcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.Launcher;

public class TestScript1 extends Launcher {
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
		homePage = pageObjectManager.getHomePageObject();
	}
	@Test
	public void login() {
		homePage.goToUrl(Constants.URL);
		homePage.closeLoginWindow();
		homePage.hoverAndclick();
		cameraPage=pageObjectManager.getCameraPageObject();
		cameraPage.addToCompair();
		cameraPage.compair();
		cameraPage.getProductDetail();
	}

}
