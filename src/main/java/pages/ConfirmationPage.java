package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class ConfirmationPage extends Base{
	WebDriver driver;
	
	@FindBy(className =   "complete-text")
	WebElement confirmationPurchase;
	
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String getConfirmationMessage() {
		return confirmationPurchase.getText();
	}
	
}
