package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Check card balance')]")
    private WebElement checkCardBalanceButton;

    public GiftCardPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void clickCheckCardBalanceButton(){
        checkCardBalanceButton.click();
    }
}
