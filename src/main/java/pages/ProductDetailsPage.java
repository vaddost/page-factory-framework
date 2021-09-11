package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailsPage extends BasePage{

    @FindBy(xpath = "//div[@class='sku product-data']//span[contains(@class,'product-data-value')]")
    private WebElement productSkuText;

    @FindBy(xpath = "//button[contains(@class,'recentlyViewed-button')]")
    private WebElement recentlyViewedButton;

    @FindBy(xpath = "//div[@class='sku-card-product-title']//a")
    private List<WebElement> recentlyViewedSlideProductTitlesList;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded(30);
    }

    public String getProductSku(){
        return productSkuText.getText();
    }

    public List<String> getProductUrlsFromRecentlyViewedCarousel(){
        recentlyViewedButton.click();
        waitUntilAllElementsAreVisible(recentlyViewedSlideProductTitlesList, 30);
        return recentlyViewedSlideProductTitlesList.stream()
                .map(x -> x.getAttribute("href"))
                .collect(Collectors.toList());
    }


}
