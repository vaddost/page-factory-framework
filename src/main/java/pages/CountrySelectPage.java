package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CountrySelectPage extends BasePage{

    @FindBy(xpath = "//div[@lang='en']//div[@class='country-selection']//a")
    private List<WebElement> countrySelectionLinks;

    public CountrySelectPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void selectCountry(String country){
        for (var countryLink : countrySelectionLinks){
            if (countryLink.getText().equals(country)){
                countryLink.click();
                break;
            }
        }
    }
}
