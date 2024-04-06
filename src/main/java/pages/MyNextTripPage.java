package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class MyNextTripPage {
    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Remove property from list")
    private RemoteWebElement removeFavourite;


    //    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[5]/android.widget.TextView[1]")
    //    private RemoteWebElement nameOfFirstFavourite;

    @FindAll({
            @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[5]/android.widget.TextView[1]"),
            @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.widget.TextView[1]"),
    })
    private RemoteWebElement nameOfFirstFavourite;

    public MyNextTripPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean removeAPropertyLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(removeFavourite)).isDisplayed();
    }

    public boolean nameOfFirstFavouriteLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(nameOfFirstFavourite)).isDisplayed();
    }

    public void clickRemoveFavouriteButton() {
        removeFavourite.click();
    }

    public String textFromFirstFavourite() {
        return nameOfFirstFavourite.getText();
    }
}

