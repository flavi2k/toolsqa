package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Flavian on 13-Mar-17.
 */
public class AccessoriesPage_POF {

    private WebDriver driver;



    @FindBy (id ="menu-item-33")
    private WebElement prodCat;

    @FindBy (id ="menu-item-34")
    private WebElement accessories;

    @FindBy (xpath = "//a[contains(.,'Apple TV')]")
    private WebElement apple;

    @FindBy (xpath = "//input[@value='Add To Cart']")
    private WebElement addToCart;

    @FindBy (xpath = "//a[@class='go_to_checkout']")
    private WebElement checkOut;

    @FindBy (css = ".continue_shopping")
    private WebElement contShopping;

    @FindBy (css = ".grid")
    private WebElement grid;


     public AccessoriesPage_POF(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAccessories() {

        Actions action = new Actions(driver);
        action.moveToElement(prodCat).moveToElement(accessories).click().build().perform();
    }

    public void clickApple () {
        apple.click();
    }

    public void addProductToCart() {
        addToCart.click();
        checkOut.click();
    }

    public void addFirstNProductsToCart(int n) throws InterruptedException {

         int max;
         grid.click();
        List<WebElement> products = driver.findElements(By.cssSelector(".wpsc_buy_button"));

        if (n<=products.size())
            max = n;
            else
            max = products.size();



            for (int i = 0; i<max; i++) {
                products.get(i).click();
                Thread.sleep(2000);
                contShopping.click();
                Thread.sleep(2000);
            }

    }
}
