package utilities;
import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	protected WebDriver driver;

	protected BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void sendValue(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public int getRating(String Str, String type) {
		int Rating;
		String s = null;
		if (type == "xGrid") {
			s = Str.replace(",", "");

		} else if (type == "xList") {
			s = Str.replace("(", "").replace(")", "").replace(",", "");
		}
		Rating = Integer.parseInt(s);
		return Rating;
	}

	public int StartIndex(String Details) {
		int start;
		if (Details.indexOf('.') == 1) {
			start = 3;
		} else {
			start = 1;
		}
		return start;
	}

	public int GetProductHigestRating(int[] Ratings) {
		int index = 0;
		int Heigest = 0;
		for (int i = 0; i < Ratings.length; i++) {
			if (Ratings[i] > Heigest) {
				Heigest = Ratings[i];
				index = i;
			}

		}
		return index;
	}

	public int lowest(int[] data)
	{
		int index=0;
		int lowest=data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] < lowest) {
				lowest = data[i];
				index = i;
			}

		}
		return index-1;

		
	}
	
	public void bestRating(int[] Ratings, String[] ProductDetail, String[] StarRating, int index) {
		for (int i = 0; i < Ratings.length; i++) {
			if (Ratings[i] == Ratings[index]) {
				System.out.println(Ratings[i]);
				System.out.println(ProductDetail[i]);
				System.out.println(StarRating[i]);
			}
		}
	}
	
	 public void hover(WebElement hoverTo,WebDriver driver) {
		 	Actions set1=new Actions(driver);
			set1.moveToElement(hoverTo).click().build().perform();

		}
	 public void goToUrl(String url) {
			driver.get(url);
		}
		
}