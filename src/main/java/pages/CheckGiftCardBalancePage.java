package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckGiftCardBalancePage extends BasePage{

    @FindBy(xpath = "//input[@id='gift-card-number']")
    private WebElement giftCardNumberInput;

    @FindBy(xpath = "//input[@id='pin-number']")
    private WebElement pinNumberInput;

    @FindBy(xpath = "//button[contains(@class,'btn-secondary')]")
    private WebElement checkBalanceButton;

    @FindBy(xpath = "//div[@id='gift-card-number-error-label']//span[@class='help-block-text']")
    private WebElement errorMessageText;

    public CheckGiftCardBalancePage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void enterCardNumber(String cardNumber){
        giftCardNumberInput.sendKeys(cardNumber);
    }

    public void enterPinNumber(String pinNumber) {
        pinNumberInput.sendKeys(pinNumber);
    }

    public void clickOnCheckBalanceButton(){
        checkBalanceButton.click();
    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(errorMessageText, 30);
        return errorMessageText.getText();
    }
}
