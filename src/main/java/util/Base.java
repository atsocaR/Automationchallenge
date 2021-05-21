package util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	private WebDriver driver;
	private WebElement element;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void typeText(By locator, String text) {
		element = getElement(locator);
		element.sendKeys(text);
		
	}
	
	public void click(By locator) {
		element = getElement(locator);
		element.click();
		
	}
	
	
	public void click(WebElement element) {
		wait(2);
		element.click();
	}
	
	
	public WebElement getElement(By locator) {
		wait(3);
		element = driver.findElement(locator);
		
		return element;
	}
	
	public List<WebElement> getElements(By locator) {
		wait(10);
		return driver.findElements(locator);
	}
	
		
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME, TimeUnit.SECONDS);
	}
	
		
	public void wait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}
	
	public boolean isDisplayedElement(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public WebDriver getDriver() {
		return driver = new ChromeDriver();
	}
	
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
}
