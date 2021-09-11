package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//div[contains(@id, 'nested-parent_processormodels')]//input[contains(@class,'c-checkbox-input')]")
    private List<WebElement> processorModelCheckboxes;

    @FindBy(xpath = "//div[@class='sku-title']//a")
    private List<WebElement> productTitleLinks;

    @FindBy(xpath = "//span[@class='item-count']")
    private WebElement itemsCountTitle;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public void filterByProcessorModel(final String processorModel){
        for (var modelCheckbox : processorModelCheckboxes){
            if (modelCheckbox.getAttribute("id").toLowerCase()
                    .contains(processorModel.replace(' ', '-').toLowerCase())){
                modelCheckbox.click();
                waitUntilGridIsRefreshed(productTitleLinks, 30);
                break;
            }
        }
    }

    public List<String> getAllProductNames(){
        return productTitleLinks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getItemsCount(){
        return itemsCountTitle.getText();
    }
}
