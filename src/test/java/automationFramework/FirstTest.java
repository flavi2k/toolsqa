package automationFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage_POF;
import pageObjects.LoginPage_POF;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {

private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");


        HomePage_POF homePage = PageFactory.initElements(driver, HomePage_POF.class);
        LoginPage_POF loginPage = PageFactory.initElements(driver,LoginPage_POF.class);
        homePage.navigateToMyAccount();
        loginPage.login();
        Thread.sleep(4000);

        WebElement cart = driver.findElement(By.cssSelector(".cart_icon .icon"));
        cart.click();

        List<WebElement> priceList = driver.findElements(By.cssSelector("#checkout_page_container .checkout_cart .pricedisplay"));

        for (int i=1; i<priceList.size();i+=3) {
            System.out.println("GET TEXT priceList (" + i + ")= " + priceList.get(i).getText());
        }

    }
}
