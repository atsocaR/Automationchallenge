package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class OverviewPage extends Base{
	WebDriver driver;
	
	@FindBy(id =  "finish")
	WebElement finishPurchaseButton;
	
	
	public OverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFinishPurchaseButton() {
		finishPurchaseButton.click();
	}
	
}
