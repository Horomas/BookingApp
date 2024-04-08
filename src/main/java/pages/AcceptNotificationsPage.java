package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class AcceptNotificationsPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private RemoteWebElement acceptNotificationsButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private RemoteWebElement allowNotificationsPopUpButton;


    public AcceptNotificationsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Notifications page is loaded")
    public boolean notificationsPageLoaded() {
        try {
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(acceptNotificationsButton))
                    .isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("The notifications popup button was not found within the timeout period: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("The notifications popup button was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("Notifications popup is loaded")
    public boolean notificationsPopupButtonLoaded() {
        try {
            return new WebDriverWait(driver, GlobalVariables.globalTimeout)
                    .until(ExpectedConditions.visibilityOf(allowNotificationsPopUpButton))
                    .isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("The notifications popup button was not found within the timeout period: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("The notifications popup button was not found: " + e.getMessage());
            return false;
        }
    }
    @Step("Notifications are accepted")
    public void clickAcceptNotificationsButton() {
            acceptNotificationsButton.click();
    }

    @Step("Notifications are accepted")
    public void clickAllowNotificationsPopUpButton() {
            allowNotificationsPopUpButton.click();
    }
}

