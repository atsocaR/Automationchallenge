package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class ProductPage extends Base{
	WebDriver driver;
	
	@FindBy(xpath = "//*[text() = 'Add to cart']")
	WebElement addToCartButton;
	
	
	@FindBy(xpath ="//a[contains(@class,'shopping_cart_link')]")
	WebElement shoppingCart;
	
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickAddToCartButton() throws InterruptedException {
		addToCartButton.click();
	}
	
	public void clickShoppingCartLink() {
		shoppingCart.click();
	}
	
	
}
