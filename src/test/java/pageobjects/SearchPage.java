package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	private static final Logger logger = LogManager.getLogger(SearchPage.class);

    private WebDriver driver;

    private By search_refinement_categories_segment  = By.id("s-refinements");
    private By product_link_list = By.xpath("//a[@class='a-link-normal a-text-normal']");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void ValidateProductSearchIsSuccessfully() {
        if (driver.findElement(search_refinement_categories_segment).isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Search Page is displayed because refinement category is displayed");
        }else{
            logger.fatal("Search Page is not displayed because refinement category is not displayed");
            Assert.fail("Search Page is not displayed because refinement category is not displayed");
        }
    }

    public String ClickOnTheProductLink(int productIndex){
        List<WebElement> listOfProducts = driver.findElements(product_link_list);
        logger.info("Number of products searched: " + listOfProducts.size());

        listOfProducts.get(productIndex).click();
        logger.info("Clicked on the Link in the List with index: " + productIndex +
                ". Link Text: " + listOfProducts.get(productIndex).getText());

        return listOfProducts.get(productIndex).getText();

}
}