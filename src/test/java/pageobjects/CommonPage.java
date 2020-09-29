package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	
    private static final Logger logger = LogManager.getLogger(CommonPage.class);

	
	WebDriver driver;
	private By SearchTextBox = By.id("twotabsearchtextbox");
	private By SearchButton = By.xpath("//input[@value='Go']");
	private By HamburgerMenu =  By.id("nav-hamburger-menu");
	private By AmazonLogo =  By.xpath("//a[@class='nav-logo-link']");
	private By Cart =  By.id("nav-cart");
	private By Prime =  By.id("nav-link-prime");
	private By AccountOrders =  By.id("nav-orders");
	private By Account =  By.id("nav-link-accountList");

	

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SeachingProduct(String text) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		WebElement searchbox = webDriverWait.until(ExpectedConditions.elementToBeClickable(SearchTextBox));
		searchbox.sendKeys(text);
		logger.info("Product name entered to search in search box: " + text);
	}

	public void ClickOnSeach() {
		boolean b = driver.findElement(SearchButton).isDisplayed();
		Assert.assertEquals("Navigating to entered product",true, b);
		driver.findElement(SearchButton).click();
		logger.info("Clicked on Search Button");
	}
	
	public void ClickHamburgerMenu() {
		boolean b = driver.findElement(HamburgerMenu).isDisplayed();
		Assert.assertEquals("Navigation to menu",true, b);
		driver.findElement(HamburgerMenu).click();
		logger.info("Navigated to menu");
	}
	
	public void CheckingLogoVisibility() {
		boolean b = driver.findElement(AmazonLogo).isDisplayed();
		Assert.assertEquals("Amazon logo visible",true, b);
		
	}
	
	public void CheckingPrimeLinkVisibility() {
		boolean b = driver.findElement(Prime).isDisplayed();
		Assert.assertEquals("Navigation to prime check",true, b);	
	}
	
    public void ClickOnCart() {
    	
    	boolean b = driver.findElement(Cart).isDisplayed();
		Assert.assertEquals("Navigation to check cart items",true, b);
		driver.findElement(Cart).click();
		logger.info("Navigated to shopping cart to proceed further");

    }
    public void ClickOnOrders() {
    	boolean b = driver.findElement(AccountOrders).isDisplayed();
		Assert.assertEquals("Navigation to check orders",true, b);
		driver.findElement(AccountOrders).click();
		logger.info("Clicked on orders tab to check all orders on account");

    }
    
    public void ClickOnAccount() {
    	boolean b = driver.findElement(Account).isDisplayed();
		Assert.assertEquals("Navigation to check Account details",true, b);
		driver.findElement(Account).click();
		logger.info("CLicked on account to check account details");    
	}
    
    public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Page title matched: " + expectedTitle );
	}
	
}
