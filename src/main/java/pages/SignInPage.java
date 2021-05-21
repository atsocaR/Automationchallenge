package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;


public class SignInPage extends Base{
	WebDriver driver;
	WebElement element;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public void setUser(String usernameText) {
		typeText(By.id("user-name"), usernameText);
	}
	
	public void setPassword(String passwordText) {
		typeText(By.id("password"), passwordText);
	}
	
	public void clickSignIn() {
		click(By.id("login-button"));		
	}
	
	public String getInvalidLoginMessage(){
		element = getElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
		return element.getText();
	}

	
	
}
