package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MacBooksProductListingPage extends BasePage{
    @FindBy(xpath = "//h4[@class='sku-header']//a")
    List<WebElement> productItemTitleLinks;

    public MacBooksProductListingPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void clickOnFirstProductFromTheGrid(){
        productItemTitleLinks.get(0).click();
    }
}
