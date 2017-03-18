package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Flavian on 13-Mar-17.
 */
public class HomePage_POF {
    private WebDriver driver;

    @FindBy(id="account")
    private WebElement myAccount;

    @FindBy (id = "account_logout")
    private WebElement logOut;

    public HomePage_POF(WebDriver driver) {
        this.driver=driver;
    }

    public void navigateToMyAccount() {
        myAccount.click();
    }

    public void logOut() {
        logOut.click();
    }

}
