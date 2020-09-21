package stepdefs;

import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CommonPage;
import pageobjects.HomePage;
import pageobjects.ProductDescriptionPage;
import pageobjects.SearchPage;
import pageobjects.SignInPage;

public class StepDefination {
	
    private static final Logger logger = LogManager.getLogger(StepDefination.class);
	
	WebDriver driver;
    String base_url = "https://amazon.in";
    int implicit_wait_timeout_in_sec = 20;
    Scenario sc;
    
    
    CommonPage commonpage;
    HomePage homepage;
    SignInPage signin;
    SearchPage searchpage;
    ProductDescriptionPage productdesc;
    
    @Before
    public void setUp(Scenario sc){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
        logger.info("Broweser invoked successfully");
        
         commonpage= new CommonPage(driver);
         homepage = new HomePage(driver);
         signin= new SignInPage(driver);
         searchpage= new SearchPage(driver);
         productdesc= new ProductDescriptionPage(driver);
    }
    
	

	/*
	 * @Given("User opened browser") public void user_opened_browser() {
	 * 
	 * driver = new FirefoxDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec,
	 * TimeUnit.SECONDS);
	 * 
	 * }
	 */



		@Given("User navigated to the home application url")
		public void NavigationToUrl() {
			
			driver.get(base_url);
	        sc.log("Browser navigated to URL: " + base_url);
	        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	        commonpage.validatePageTitleMatch(expected);
	        sc.log("Page title validation successfully. Actual title: " + expected );
		    
		}
		@When("User Search for product {String}")
		public void SearchingforProduct(String productName) {
			
        commonpage.SeachingProduct("productName");
        commonpage.ClickOnSeach();
        sc.log("Searched product"+productName);
		       
		    
		}
		@Then("Search Result page is displayed")
		public void ResultDisplayforSearchProduct() {
        searchpage.ValidateProductSearchIsSuccessfully();			 
		}


			@When("User click on any product")
			public void user_click_on_any_product() {
				 searchpage.ClickOnTheProductLink(0);
			}



			@Then("Product Description is displayed in new tab")
			public void product_description_is_displayed_in_new_tab() {
				
				
		        Set<String> handles = driver.getWindowHandles(); 
		        Iterator<String> it = handles.iterator(); 
		        String original = it.next();
		        String prodDescp = it.next();
                driver.switchTo().window(prodDescp);
                
		        productdesc.ValidateAddToCartButtonIsCorrectlyDisplayed();
		        productdesc.ValidateProductTileIsCorrectlyDisplayed();
		   }



			@After
		    public void cleanUp(){
		        driver.quit();
		    }


}
