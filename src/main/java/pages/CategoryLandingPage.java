package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryLandingPage extends BasePage{

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class, 'imageAndLink-type')]//a[contains(text(), 'Apple')]")
    private WebElement appleShopByBrandLink;

    public CategoryLandingPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void clickOnAppleShopByBrandLink(){
        appleShopByBrandLink.click();
    }
}
