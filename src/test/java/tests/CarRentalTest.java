package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;
import util.Helpers;

@Epic("Regression Tests")
@Feature("CarRentalTest")
public class CarRentalTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify that a car which is selected for pickup and dropoff trip has an automatic gearbox")
    @Test(testName = "Car rental test")
    public void bookingTest2() {
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
        Assert.assertTrue(basePage.signInSectionButtonLoaded(), "Sign in section button is not loaded");                            //2. Navigate to Sign in tab.
        basePage.clickSignInSectionButton();
        Assert.assertTrue(signInPage.geniusLoyaltyButtonLoaded(), "Genius loyalty section button is not loaded");                                   //3. Click on Genius loyalty program.
        signInPage.clickGeniusLoyaltyButton();
        Assert.assertTrue(geniusLoyaltyPage.aboutGeniusContentLoaded(), "Genius loyalty section button is not loaded");
        helpers.swipeVertically(driver, Helpers.Directions.UP,3);                                                                              //4. Scroll down to About Genius Levels and click on it.
        geniusLoyaltyPage.clickAboutGenius();
        helpers.swipeHorizontally(driver, Helpers.Directions.LEFT, 3);                                                                         //5. Swipe right to Genius Level 3 and validate that it is displayed.
        Assert.assertTrue(aboutGeniusPage.aboutGeniusContentLoaded(), "About Genius Level 3 is not loaded");
        Assert.assertTrue(aboutGeniusPage.gotItButtonLoaded(), "Got ot button is not loaded");
        aboutGeniusPage.clickGotItButton();                                                                                                                  //6. Click on Got it button.
        Assert.assertTrue(basePage.backButtonLoaded(), "Back to search is not loaded");                                                             //7. Click on back button.
        basePage.clickBackButton();
        Assert.assertTrue(basePage.searchSectionButtonLoaded(), "Saved button is not loaded");                                                            //8. Navigate to Search tab.
        basePage.clickSearchSectionButton();
        Assert.assertTrue(tripInformationEntryPage.carRentalButtonLoaded(), "Car rental button is not loaded");                                     //9. Click on Car rental.
        tripInformationEntryPage.clickCarRentalButton();
        Assert.assertTrue(tripInformationEntryPage.returnSameLocationSwitchLoaded(), "Car rental return switch is not loaded");                              //10. Disable Return to same location button and validate that now pickup location and drop-off location are displayed.
        tripInformationEntryPage.clickReturnSameLocationSwitch();
        Assert.assertTrue(tripInformationEntryPage.pickupLocationFieldLoaded(), "Pick up location field is not loaded");
        tripInformationEntryPage.clickPickupLocationField();
        tripInformationEntryPage.enterPickupLocation("Skopje");                                                                                      //11. Add Skopje as Pickup location and Ohrid as Drop-off location
        Assert.assertTrue(tripInformationEntryPage.choosePickupContentLoaded(),"Pick up location is not loaded");
        tripInformationEntryPage.clickChoosePickupContent();
        Assert.assertTrue(tripInformationEntryPage.dropoffLocationFieldLoaded(),"Pick up location is not loaded");
        tripInformationEntryPage.clickDropoffLocationField();
        tripInformationEntryPage.enterDropoffLocation("Ohrid");
        Assert.assertTrue(tripInformationEntryPage.chooseDropoffContentLoaded(),"Drop-off location is not loaded");
        tripInformationEntryPage.clickDropoffPickupContent();
        Assert.assertTrue(tripInformationEntryPage.chooseCarPickupDateLoaded(),"Car pickup date is not loaded");                                       //12. Select 24 April to 27 April 2024 as dates.
        tripInformationEntryPage.clickChoosePickupDateField();
        tripInformationEntryPage.clickEnterDatePickup();
        tripInformationEntryPage.clickEnterDateDropoff();
        tripInformationEntryPage.clickConfirmChosenDates();
        Assert.assertTrue(tripInformationEntryPage.choosePickupTimeFieldLoaded(),"Car pickup time is not loaded");                                     //13. Select 08:15 AM as Pickup time and 11:00 AM as Drop-off time.
        tripInformationEntryPage.clickChoosePickupTimeField();
        helpers.swipeVertically(driver, Helpers.Directions.DOWN,2);
        Assert.assertTrue(tripInformationEntryPage.choosePickupTimeLoaded(),"Car pickup time allocation is not loaded");
        tripInformationEntryPage.clickChoosePickupTime();
        Assert.assertTrue(tripInformationEntryPage.chooseDropoffTimeFieldLoaded(),"Car dropoff time is not loaded");
        tripInformationEntryPage.clickChooseDropoffTimeField();
        Assert.assertTrue(tripInformationEntryPage.chooseDropoffTimeLoaded(),"Car dropoff time allocation is not loaded");
        tripInformationEntryPage.clickChooseDropoffTime();
        Assert.assertTrue(tripInformationEntryPage.driversAgeFieldLoaded(),"Drivers age field is not loaded");                                          //14. In Driver’s age enter your age.
        tripInformationEntryPage.clickDriversAgeField();
        Assert.assertTrue(tripInformationEntryPage.driversAgeFieldLoaded(),"Drivers age field is not loaded");
        helpers.clickByCoordinates(driver, 676, 1724);
        helpers.clickByCoordinates(driver, 680, 2029);
        helpers.clickByCoordinates(driver, 957, 2190);
        Assert.assertTrue(tripInformationEntryPage.searchButtonLoaded(),"Search button is not loaded");                                                 //15. Click Search.
        tripInformationEntryPage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.filterButtonLoaded(), "Filter button is not Loaded");                                                       //16. Filter cars by Automatic and validate that first displayed car is automatic.
        searchResultsPage.clickFilterButton();
        Assert.assertTrue(filterPage.automaticButtonLoaded(), "Automatic filter button is not Loaded");
        filterPage.clickAutomaticButton();
        Assert.assertTrue(filterPage.showResultsButtonLoaded(), "Show filter results button is not Loaded");
        filterPage.clickShowResultsButton();
        String firstGearbox = searchResultsPage.textFirstCarGearbox();
        Assert.assertTrue(firstGearbox.contains("Automatic"));

    }

}
