package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	 private static final Logger logger = LogManager.getLogger(SignInPage.class);

	    private WebDriver driver;

	    private By EmailTextBox  = By.id("ap_email");

    public SignInPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    public void CheckingVisibilityAndEnteringEmail(String text) {
    	boolean b=driver.findElement(EmailTextBox).isDisplayed();
		Assert.assertEquals("Email text box visible",true, b);
        driver.findElement(EmailTextBox).sendKeys(text);
        logger.info("Enetred email to sign in");
    }
}
