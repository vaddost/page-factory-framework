package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductDetailsPageTests extends BaseTest{

    public static final String FIRST_LEVEL_NAV_TITLE = "Computers & Tablets";
    public static final String SECOND_LEVEL_NAV_TITLE = "Laptops & Desktops";
    public static final String THIRD_LEVEL_NAV_TITLE = "Laptops";

    @Test
    public void testProductIsPresentInRecentlyViewedCarouselAfterOpeningProductDetailsPage(){
        var homePage = getHomePage();
        homePage.closeModalWindow();
        homePage.openCategoryLandingPageFromMainMenu(FIRST_LEVEL_NAV_TITLE,
                SECOND_LEVEL_NAV_TITLE, THIRD_LEVEL_NAV_TITLE);
        var categoryLandingPage = getCategoryLandingPage();

        assertEquals(categoryLandingPage.getPageTitle(), THIRD_LEVEL_NAV_TITLE);

        categoryLandingPage.clickOnAppleShopByBrandLink();

        var macBooksPage = getMacBooksProductListingPage();
        macBooksPage.clickOnFirstProductFromTheGrid();

        var productDetailsPage = getProductDetailsPage();
        String productSku = productDetailsPage.getProductSku();
        productDetailsPage.refreshPage();
        List<String> productUrlsFromRecentlyViewed = productDetailsPage.getProductUrlsFromRecentlyViewedCarousel();

        boolean productIsFound = false;

        for (var productUrl : productUrlsFromRecentlyViewed){
            if (productUrl.contains(productSku)){
                productIsFound = true;
                break;
            }
        }

        assertTrue(productIsFound);


    }
}
