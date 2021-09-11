package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[contains(@class, 'c-modal-grid')]//button[contains(@class,'c-close-icon')]")
    private WebElement modalCloseButton;

    @FindBy(xpath = "//input[@id='gh-search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='header-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class, 'hamburger-menu-button')]")
    private WebElement menuButton;

    @FindBy(xpath = "//button[contains(@class, 'hamburger-menu-flyout-list-item')]")
    private List<WebElement> mainNavigationButtons;

    @FindBy(xpath = "//ul[contains(@class, 'hamburger-menu-flyout-sidecar-list')]//a")
    private List<WebElement> sidebarNavigationLinks;

    @FindBy(xpath = "//div[contains(@class, 'utility-nav-more-drawer')]//button[contains(@class, 'plButton')]")
    private WebElement moreButton;

    @FindBy(xpath = "//div[contains(@class, 'bottom-nav-left-wrapper')]//a[contains(text(), 'Gift Cards')]")
    private WebElement giftCardsPageLink;

    public HomePage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void closeModalWindow(){
        modalCloseButton.click();
        waitUntilPageIsLoaded(30);
    }
    public void enterSearchTermInSearchField(final String searchTerm){
        waitUntilElementIsClickable(searchInput, 30);
        searchInput.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void openCategoryLandingPageFromMainMenu(String categoryText, String firstLevelSubcategoryText,
                                                   String secondLevelSubcategoryText){
        menuButton.click();
        clickOnMenuNavigationButton(categoryText);
        clickOnMenuNavigationButton(firstLevelSubcategoryText);
        clickOnSidebarLink(secondLevelSubcategoryText);
    }

    public void clickOnGiftCardsLink(){
        moreButton.click();
        getJavaScriptExecutor().executeScript("arguments[0].click()", giftCardsPageLink);
    }

    private void clickOnMenuNavigationButton(String itemText){
        for (var menuItem : mainNavigationButtons){
            if (menuItem.getText().equals(itemText)){
                menuItem.click();
                break;
            }
        }
    }

    private void clickOnSidebarLink(String linkText){
        for (var sidebarLink : sidebarNavigationLinks){
            if (sidebarLink.getText().equals(linkText)){
                sidebarLink.click();
                break;
            }
        }
    }
}
