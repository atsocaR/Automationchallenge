package testcases;


import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomePage;
import pages.SignInPage;
import util.DataTestReader;
import util.UserCredentials;


public class SortProductsByPriceTest {

	@Test
	public void sortProductsByPrice() throws InterruptedException {
		
		Reporter.log("==========================================");
		Reporter.log("Starting Test: "+ this.getClass().getName());
		Reporter.log("==========================================");
		
		for(int i=0; i<validCredentials.size(); i++) {
			signInPage.setUser(validCredentials.get(i).getUsername());
			signInPage.setPassword(validCredentials.get(i).getPassword());
			signInPage.clickSignIn();
			homePage = new HomePage(driver);
			homePage.clickSortByLowHighPrice();
			Assert.assertTrue(homePage.isSortedByPrice());
		}
	}

		
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver 		= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
			driver 		= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/msedgedriver.exe");
			driver 		= new EdgeDriver();
		}
		
		signInPage 	= new SignInPage(driver);
		driver.get(loginUrl);
		driver.manage().window().maximize();
		signInPage.implicitWait();
	}

	@AfterClass
	public void tearDown() {
		signInPage.implicitWait();
		driver.quit();
	}
	
	//driver
	private WebDriver 			driver;
	
	//Page Object Model 
	private SignInPage 	signInPage;
	private HomePage 	homePage;
	

	//Test data 
	private String 				loginUrl 				= DataTestReader.getUrl("./src/test/resources/", "testData.xlsx", "url");
	private List<UserCredentials> validCredentials 		= DataTestReader.getCredentials("./src/test/resources/", "testData.xlsx", "valid_login");
}
