package page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class CameraPage extends BaseClass {
	WebDriver driver;

	public CameraPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Add to Compare']")
	WebElement compair;

	@FindBy(xpath = "//span[text()='COMPARE']")
	WebElement compairButton;
	
	@FindBy(xpath = "(//div[@class='row'])[2]")
	WebElement productDetail;

	@FindBy(xpath = "(//div[@class='row'])[3]")
	WebElement priceDetail;

	ArrayList<WebElement> product = new ArrayList<WebElement>();

	public void addToCompair() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// compair.click();
		wait.until(ExpectedConditions.visibilityOf(compair));
		product = (ArrayList<WebElement>) (driver.findElements(By.xpath("//span[text()='Add to Compare']")));
		for (int i = 0; i < 3; i++) {
			product.get(i).click();
		}
	}

	public void compair() {
		click(compairButton);
	}

	public void getProductDetail()

	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(priceDetail));
		String priceDetails=priceDetail.getText();
		//System.out.println(priceDetails);
		String productDetails=productDetail.getText();
		String[] price=priceDetails.split("\n");
		String[] details=productDetails.split("\n");
		//System.out.println(productDetails);
		int[] intPrice=new int[5];
		for(int i=0;i<price.length;i++)
		{
			int index=price[i].lastIndexOf('₹');
			String testPrice=price[i].substring(1, index).replace("?", "").replace(",", "");
			//System.out.println(testPrice);
			intPrice[i]=Integer.parseInt(testPrice);
		}
		int index=lowest(intPrice);
		System.out.println(intPrice[index]);
		System.out.println(details[index]);
		
	}

}
