package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Flavian on 13-Mar-17.
 */
public class LoginPage_POF {

    private WebDriver driver;

    @FindBy(id = "log")
    private WebElement log;

    @FindBy (id="pwd")
    private    WebElement pwd;

    @FindBy (id="login")
    private WebElement login;

    @FindBy (id = "account_logout")
    private WebElement logOut;




    public LoginPage_POF(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        log.sendKeys("clr");
        pwd.sendKeys("test123");
        login.click();

        //Assert.assertEquals("Howdy, clr", driver.findElement(By.xpath("//a[contains(.,'Howdy, clr')]")).getText().toString());
    }

    public void login(String username, String password) {
        log.sendKeys(username);
        pwd.sendKeys(password);
        login.click();
    }
}
