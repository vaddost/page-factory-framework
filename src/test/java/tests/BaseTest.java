package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String COUNTRY = "United States";
    private static final String BASE_URL = "https://www.bestbuy.com/";

    @BeforeTest
    public void profileSetUp(){
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        getCountrySelectPage().selectCountry(COUNTRY);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    public WebDriver getDriver(){
        return driver;
    }
    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public CountrySelectPage getCountrySelectPage(){
        return new CountrySelectPage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage(getDriver());
    }

    public CategoryLandingPage getCategoryLandingPage(){
        return new CategoryLandingPage(getDriver());
    }

    public MacBooksProductListingPage getMacBooksProductListingPage(){
        return new MacBooksProductListingPage(getDriver());
    }

    public ProductDetailsPage getProductDetailsPage(){
        return new ProductDetailsPage(getDriver());
    }

    public GiftCardPage getGiftCardPage(){
        return new GiftCardPage(getDriver());
    }

    public CheckGiftCardBalancePage getCheckGiftCardBalancePage(){
        return new CheckGiftCardBalancePage(getDriver());
    }
}
