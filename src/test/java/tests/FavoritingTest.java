package tests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TripInformationEntryPage;
import util.DriverSetup;
import util.Helpers;
import pages.SearchResultsPage;

@Epic("Regression Tests")
@Feature("CarRentalTest")
public class FavoritingTest extends DriverSetup {


    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify that the location can be favorited and that the currency is changed")
    @Test(testName = "Favoriting test")
    public void bookingTest1() {

        Assert.assertTrue(cookiePage.cookiePageLoaded(), "Cookie page is not loaded");                                                          //1. Start the Booking application and continue without sign in.
        cookiePage.clickAcceptCookieButton();
//        try {
//            // Attempt to assert that the notifications page is loaded
//            Assert.assertTrue(acceptNotificationsPage.notificationsPageLoaded(), "Notifications page is not loaded");
//            // If the assertion passes, click the accept notifications button
//            acceptNotificationsPage.clickAcceptNotificationsButton();
//        } catch (AssertionError e) {
//            // Handle the assertion error if the notifications page is not loaded
//            System.out.println("Assertion failed: " + e.getMessage());
//            // Optionally, rethrow the exception or perform other actions
//        }
//
//        try {
//            // Attempt to assert that the notifications popup button is loaded
//            Assert.assertTrue(acceptNotificationsPage.notificationsPopupButtonLoaded(), "Notifications pop-up page is not loaded");
//            // If the assertion passes, click the allow notifications popup button
//            acceptNotificationsPage.clickAllowNotificationsPopUpButton();
//        } catch (AssertionError e) {
//            // Handle the assertion error if the notifications popup button is not loaded
//            System.out.println("Assertion failed: " + e.getMessage());
//            // Optionally, rethrow the exception or perform other actions
//        }

        Assert.assertTrue(basePage.backButtonLoaded(), "Login skip button is not loaded");
        basePage.clickBackButton();
        Assert.assertTrue(tripInformationEntryPage.tripInformationEntryPageLoaded(), "Trip information entry page is not loaded");
        tripInformationEntryPage.clickDestinationField();
        Assert.assertTrue(tripInformationEntryPage.enterDestination(), "Trip information entry field is not loaded");
        tripInformationEntryPage.enterDestination("Skopje");                                                                                             //2. Select Skopje as destination.
        Assert.assertTrue(tripInformationEntryPage.selectFirstOptionAvailable(), "Results are not visible");
        tripInformationEntryPage.clickFirst();
        Assert.assertTrue(tripInformationEntryPage.selectDateStartLoaded(), "Start date is not available");                                     //3. Select 24 - 28 April as date.
        tripInformationEntryPage.clickStartDate();
        Assert.assertTrue(tripInformationEntryPage.selectDateEndLoaded(), "End date is not available");
        tripInformationEntryPage.clickEndDate();
        Assert.assertTrue(tripInformationEntryPage.selectDateButtonLoaded(), "Confirm button was not found");
        tripInformationEntryPage.clickSelectDatesButton();
        Assert.assertTrue(tripInformationEntryPage.roomSelectionLoaded(), "Room selection was not loaded");                                     //4. Select 2 rooms and 3 adults.
        tripInformationEntryPage.clickRoomSelection();
        Assert.assertTrue(tripInformationEntryPage.increaseRoomsLoaded(), "Room increase options was not loaded");
        tripInformationEntryPage.clickRoomIncreaseButton();
        Assert.assertTrue(tripInformationEntryPage.increaseAdultsLoaded(), "Adults increase options was not loaded");
        tripInformationEntryPage.clickAdultIncreaseButton();
        Assert.assertTrue(tripInformationEntryPage.applyButtonToTripInformation(), "Apply button to trip information was not loaded");
        tripInformationEntryPage.clickApplyChangesToTrip();
        Assert.assertTrue(tripInformationEntryPage.searchForTripLoaded(), "Search for trip was not loaded");                                    //5. Click Search.
        tripInformationEntryPage.clickSearchForTripButton();
        Assert.assertTrue(tripInformationEntryPage.searchDestinationLoaded(), "Search trip destination was not loaded");                        //6. On booking search screen validate expected destination and date is visible.
        Assert.assertTrue(tripInformationEntryPage.getTripDataDestination("Skopje"), "Text does not equal 'Skopje'");
        Assert.assertTrue(tripInformationEntryPage.getTripDataDate("Apr 24 - Apr 28"), "Text does not equal 'Apr 24 - Apr 28'");
        Assert.assertTrue(searchResultsPage.favouritesFirstResultLoaded(), "Favourite first search result is not loaded");                          //7. Click on Save button (heart) on one of the listed properties.
        searchResultsPage.clickFavouriteFirstButton();
        String firstFavouriteText = searchResultsPage.textFromFirstFavourite();
        Assert.assertTrue(basePage.backButtonLoaded(), "Back to search is not loaded");                                                  //8. Go back to the search page.
        basePage.clickBackButton();
        Assert.assertTrue(basePage.savedSectionButtonLoaded(), "Favourites list access is not loaded");                                        //9. Click on Saved tab.
        basePage.clickSavedSectionButton();
        Assert.assertTrue(savedPage.savedPageLoaded(), "Saved list access is loaded");
        savedPage.clickFavouritesListButton();
        Assert.assertTrue(myNextTripPage.nameOfFirstFavouriteLoaded(), "Favourites list is not loaded");                                            //10. Validate property is shown in Saved tab.
        String firstFavouriteText1 = myNextTripPage.textFromFirstFavourite();
        Assert.assertEquals(firstFavouriteText1, firstFavouriteText);
        Assert.assertTrue(basePage.backButtonLoaded(), "Back to saved is not loaded");                                                       //11. Go back to the search page.
        basePage.clickBackButton();
        Assert.assertTrue(basePage.backToSearchLoaded(), "Back to search is not loaded");
        basePage.clickBackToSearchButton();
        Assert.assertTrue(basePage.signInSectionButtonLoaded(), "Sign in section button is not loaded");                            //12. Click on Sign in tab and validate that user is not logged in.
        basePage.clickSignInSectionButton();
        Assert.assertTrue(signInPage.signInButtonLoaded(), "Sign in action is not available");                                                      //13. Click on Sign in tab and validate that user is not logged in.
        helpers.swipeVertically(driver, Helpers.Directions.UP);
        Assert.assertTrue(signInPage.signSettingsButtonLoaded(), "Settings button is not loaded");                                                  //14. Scroll down to and click Settings.
        signInPage.clickSettingsButton();
        Assert.assertTrue(settingsPage.currencySelectionLoaded(), "Currency button is not loaded");                                                 //15. Click Currency.
        settingsPage.clickCurrencySelectionButton();
        Assert.assertTrue(currencyPage.currencySelectionFieldLoaded(), "Currency selection field is not loaded");                                   //16. Change Currency to Euro.
        currencyPage.enterCurrency("euro");
        Assert.assertTrue(currencyPage.euroLoaded(), "Euro selection field is not loaded");
        currencyPage.clickEuro();
        Assert.assertTrue(settingsPage.selectedCurrencyLoaded(), "Currency type field is not loaded");
        String selectedCurrencyType = settingsPage.getSelectedCurrency();
        Assert.assertEquals(selectedCurrencyType, "Euro (€)");                                                                                      //17. Validate that Settings Currency is changed now to Euro.
        Assert.assertTrue(settingsPage.privacyPolicyFieldLoaded(), "Privacy policy field is not loaded");                                           //18. Click on Privacy Policy and validate that Privacy and Cookies policy is open.
        settingsPage.clickPrivacyPolicyField();
        Assert.assertTrue(privacyPolicyPage.privacyPolicyContentLoaded(), "Privacy policy content is not loaded");

    }
}


