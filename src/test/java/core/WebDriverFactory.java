package core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
	
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver driver=null;
    public static WebDriver DriverSelection(String browser) throws Exception 
    {
        switch(browser.toLowerCase())
        {
            case "chrome":
                          driver = new ChromeDriver();
                          logger.info("Chrome Browser invoked");
                          break;
            case "firefox":
                          driver = new FirefoxDriver();
                          logger.info("Firefox Browser invoked");
                          break;
            case "headless":
                           FirefoxOptions options = new FirefoxOptions();
                           options.addArguments("headless");
                           options.addArguments("window-size=1200x600");
                           driver = new FirefoxDriver(options);
                           logger.info("Headless Chrome Browser invoked");
                           break;
            default:
                           logger.fatal("No such browser is implemented.Browser name sent: " + browser);
                           throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

}
    
    public static void Navigation_Url(String url)  {
                 driver.get(url);
                 logger.info("Successfully navigated to given url");
    }
    
    public static void Driver_Quit()  {
    	driver.quit();
    }
    
    public void BrowserTabSwitching()  {
    	Set<String> handles=driver.getWindowHandles();
    	Iterator<String> it=handles.iterator();
    	String Original=it.next();
    	String New=it.next();
    	driver.switchTo().window(New);
    	logger.info("Switched to new tab");
    }
    
    public static String GetBrowserName() {
    	String defaultbrowser="firefox";
    	String browserfromcmd=System.getProperty("browser");
    	if(browserfromcmd==null) {
    		return defaultbrowser;
    	}else {
    		return browserfromcmd;

    	}
    	
    }
}