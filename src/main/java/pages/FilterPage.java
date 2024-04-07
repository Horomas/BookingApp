package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class FilterPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Automatic']")
    private RemoteWebElement automaticButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show results']")
    private RemoteWebElement showResultsButton;



    public FilterPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean automaticButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(automaticButton)).isDisplayed();
    }
    public boolean showResultsButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(showResultsButton)).isDisplayed();
    }




    public void clickAutomaticButton() {
        automaticButton.click();
    }
    public void clickShowResultsButton() {
        showResultsButton.click();
    }

}
