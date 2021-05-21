package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class CartProductsPage extends Base{
	WebDriver driver;
	
	@FindBy(className =  "inventory_item_name")
	List<WebElement> productNameList;
	
	@FindBy(className = "checkout_button")
	WebElement checkOutButton;
	
	
	public CartProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> unSortedPricesList;
	
	
	public void clickCheckOutButton() {
		implicitWait();
		checkOutButton.click();
	}
	
	
	public boolean isProductNameAdded(String productName) throws InterruptedException {
		boolean productAdded = false;
		implicitWait();
		
		for(WebElement element : productNameList) {
			if(element.getText().equals(productName)) {
				productAdded =true;
				break;
			}
		}
		
		return productAdded;
	}
	
	
	
}
