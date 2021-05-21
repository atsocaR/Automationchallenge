package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Base;

public class CheckOutInfoPage extends Base{
	WebDriver driver;
	
	@FindBy(id =  "first-name")
	WebElement firstNameText;
	
	@FindBy(id =  "last-name")
	WebElement lastNameText;
	
	@FindBy(id =  "postal-code")
	WebElement postalCodeText;
	
	@FindBy(id =  "continue")
	WebElement continueButton;
	
	
	public CheckOutInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	
	public void setFirstName() {
		
		getElement(By.id("first-name")).sendKeys("first name");
		//firstNameText.sendKeys("first name");
	}
	
	
	public void setLastName() {
		getElement(By.id("last-name")).sendKeys("last name");
		//lastNameText.sendKeys("last name");
	}
	
	public void setPostalCode() {
		getElement(By.id("postal-code")).sendKeys("76240");
		//postalCodeText.sendKeys("76240");
	}
	
	public void clickContinueButton() {
		getElement(By.id("continue")).click();
	}
	
}
