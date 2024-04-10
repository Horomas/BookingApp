package util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
//import pages.*;

import java.net.MalformedURLException;
import java.net.URI;

import java.net.URISyntaxException;

import org.openqa.selenium.Platform;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;

    public DesiredCapabilities capabilities = new DesiredCapabilities();

    protected Helpers helpers;

    protected CookiePage cookiePage;
    protected AcceptNotificationsPage acceptNotificationsPage;
    protected TripInformationEntryPage tripInformationEntryPage;
    protected SearchResultsPage searchResultsPage;
    protected SavedPage savedPage;
    protected MyNextTripPage myNextTripPage;
    protected SignInPage signInPage;
    protected SettingsPage settingsPage;
    protected CurrencyPage currencyPage;
    protected PrivacyPolicyPage privacyPolicyPage;
    protected GeniusLoyaltyPage geniusLoyaltyPage;
    protected AboutGeniusPage aboutGeniusPage;
    protected BasePage basePage;
    protected FilterPage filterPage;

    @BeforeMethod
    public void setUp() {

        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(UiAutomator2Options.UDID_OPTION, getProperty("device.udid"));
        capabilities.setCapability(UiAutomator2Options.AUTOMATION_NAME_OPTION, getProperty("automation.name"));
        capabilities.setCapability(UiAutomator2Options.APP_OPTION, getProperty("path.to.app"));
        capabilities.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION, getProperty("app.activity"));
        capabilities.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION, getProperty("app.package"));
        capabilities.setCapability(UiAutomator2Options.NO_RESET_OPTION, false);
        capabilities.setCapability(UiAutomator2Options.FULL_RESET_OPTION, true);
        capabilities.setCapability(UiAutomator2Options.AUTO_GRANT_PERMISSIONS_OPTION, true);
        capabilities.setCapability("appium:disableIdLocatorAutocompletion", true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }



        helpers = new Helpers();

        cookiePage = new CookiePage(driver);
        acceptNotificationsPage = new AcceptNotificationsPage(driver);
//        loginPage = new LoginPage(driver);
        tripInformationEntryPage = new TripInformationEntryPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        savedPage = new SavedPage(driver);
        myNextTripPage = new MyNextTripPage(driver);
        signInPage = new SignInPage(driver);
        settingsPage = new SettingsPage(driver);
        currencyPage = new CurrencyPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        geniusLoyaltyPage = new GeniusLoyaltyPage(driver);
        aboutGeniusPage = new AboutGeniusPage(driver);
        basePage = new BasePage(driver);
        filterPage = new FilterPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
