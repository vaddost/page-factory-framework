package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest{

    public static final String SEARCH_TERM = "lenovo ideapad";
    public static final String PROCESSOR_MODEL = "Intel Core i3";

    @Test
    public void testCheckFilteringByProcessorModel(){
        var homePage = getHomePage();
        homePage.closeModalWindow();
        homePage.enterSearchTermInSearchField(SEARCH_TERM);
        homePage.clickSearchButton();
        var searchPage = getSearchResultsPage();
        searchPage.filterByProcessorModel(PROCESSOR_MODEL);

        String itemsCount = searchPage.getItemsCount();
        List<String> itemNames = searchPage.getAllProductNames();

        assertEquals(itemsCount, itemNames.size() + " items");

        itemNames.forEach(x -> assertTrue(x.contains(PROCESSOR_MODEL)));
    }
}
