package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_exl {
	String data[][];

	public String[][] Read_excel(String file, String Sheet) {
		File f = new File(file);

		try {

			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet se = wb.getSheet(Sheet);
			data = new String[2][2];

			for (int i = 0; i <= 1; i++) {
				XSSFRow row = se.getRow(i + 1);
				data[i][0] = row.getCell(1).getStringCellValue();
				data[i][1] = row.getCell(2).getStringCellValue();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
