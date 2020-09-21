package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);
    
    WebDriver driver;
    
    private By SignInAccount = By.linkText("Sign in securely");
    
    public HomePage(WebDriver driver)  {
        this.driver = driver;
    }
    
    public void ClickToSignIn()  {
    	
    	driver.findElement(SignInAccount).click();
    	logger.info("Sign In Successfully");
    	
    }
    
}