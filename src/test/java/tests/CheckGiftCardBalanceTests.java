package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckGiftCardBalanceTests extends BaseTest{


    public static final String CARD_NUMBER = "1234";
    public static final String PIN_NUMBER = "123";
    public static final String INVALID_CARD_ERROR_MESSAGE = "Please enter a valid gift card number.";

    @Test
    public void testErrorMessageIfCardNumberIsInvalid(){
        var homePage = getHomePage();
        homePage.closeModalWindow();
        homePage.clickOnGiftCardsLink();
        getGiftCardPage().clickCheckCardBalanceButton();
        var checkBalancePage = getCheckGiftCardBalancePage();
        checkBalancePage.enterCardNumber(CARD_NUMBER);
        checkBalancePage.enterPinNumber(PIN_NUMBER);
        checkBalancePage.clickOnCheckBalanceButton();
        String errorMessage = checkBalancePage.getErrorMessage();

        assertEquals(errorMessage, INVALID_CARD_ERROR_MESSAGE);
    }
}
