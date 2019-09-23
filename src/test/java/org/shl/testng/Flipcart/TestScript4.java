package org.shl.testng.Flipcart;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Read_exl;
import utilities.Constants;
import utilities.ExcelCreaterWriter;

public class TestScript4 {

	@BeforeClass
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
	public void launch(String url, String Browser) throws Exception {
		System.out.println(url);
		System.out.println(Browser);

	}

}
