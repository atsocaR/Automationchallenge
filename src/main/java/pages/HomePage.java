package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.Base;

public class HomePage extends Base{
	WebDriver driver;
	WebElement element;
	List<WebElement> unsortedPricesList;
	List<WebElement> sortedPricesList;
	List<WebElement> products;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public void clickHomeMenuButton() throws InterruptedException {
		element = getElement(By.id("react-burger-menu-btn"));
		click(element);
	}
	
	public void clickLogOutOption() throws InterruptedException {
		element = getElement(By.id("logout_sidebar_link"));
		click(element);
	}
	
	public String currentUrl() {
		return getCurrentUrl();
	}
	
	public boolean isLoginSuccess(){
		return isDisplayedElement(By.className("peek"));
	}
	

	public void clickSortMenuButton() {
		element = getElement(By.xpath("//select[contains(@class,'product_sort_container')]"));
		click(element);
	}
	
	public void clickSortByLowHighPrice() {
		clickSortMenuButton();
		unsortedPricesList = getElements(By.xpath("//div[contains(@class,'inventory_item_price')]"));
		element = getElement(By.xpath("//select[contains(@class,'product_sort_container')]"));
		selectOptionMenuSort(element);
	}
	
	public void selectOptionMenuSort(WebElement element) {
		Select optionSelect = new Select(element);
		optionSelect.selectByValue("lohi");
	}
	
	public void addAllProducts() {
		products = getElements(By.xpath("//*[text() = 'Add to cart']"));
		for(WebElement element : products) {
			click(element);
		}
		
	}
	
	public boolean allProductsAdded() {
		element = getElement(By.className("shopping_cart_badge"));
		
		Integer numAddedProducts = Integer.valueOf(element.getText());
		Integer productsSize = products.size();
		
		return numAddedProducts.equals(productsSize);
	}
	
	
	public boolean isSortedByPrice() {
		sortedPricesList = getElements(By.xpath("//div[contains(@class,'inventory_item_price')]"));
		
		return !sortedPricesList.equals(unsortedPricesList);
	}
	
	public void clickProductByName(String productName) {
		
		List<WebElement> productNameList = getElements(By.className("inventory_item_name"));
		
		for(WebElement element : productNameList) {
			if(element.getText().equals(productName)) {
				click(element);
				break;
			}
		}
	}
	
}
