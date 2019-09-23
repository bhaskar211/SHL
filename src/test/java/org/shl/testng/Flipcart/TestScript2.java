package org.shl.testng.Flipcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.HomePageAmazon;
import utilities.Constants;
import utilities.Launcher;

public class TestScript2 extends Launcher {

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
		homePageAmazon = pageObjectManager.getHomePageAmazonObject();
	}
	@Test
	public void login() {
		homePageAmazon.goToUrl(Constants.URLA);
		homePageAmazon.searchProuct(Constants.PRODUCTA);
		homePageAmazon.selectCategory();
		homePageAmazon.sort();
		homePageAmazon.getitem();
		
	}
	
	

}
