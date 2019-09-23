package org.shl.testng.Flipcart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.HomePage;
import utilities.Read_exl;
import utilities.BaseClass;
import utilities.Constants;
import utilities.ExcelCreaterWriter;
import utilities.Launcher;

public class TestScript3 extends Launcher {

	// WebDriver driver;
	@BeforeTest()
	public void Create() throws IOException {
		ExcelCreaterWriter excel = new ExcelCreaterWriter();
		excel.ExcelWriter(Constants.URLDATA);

	}

	@DataProvider(name = "Data")
	public String[][] Exl_Data() throws IOException {
		Read_exl Read = new Read_exl();
		return Read.Read_excel(Constants.FILE, Constants.SHEET);

	}

	@Test(dataProvider = "Data")
	public void launch(String url, String browser) throws Exception {
		Constants.URL = url;
		Constants.BROWSER = browser;
		launchBrowser();
		homePage = pageObjectManager.getHomePageObject();
		homePage.goToUrl(Constants.URL);
		driver.quit();

	}

}
