package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Flavian on 15-Mar-17.
 */
public class CheckOut_POF {

    private WebDriver driver;

    @FindBy(css = ".adjustform.qty>input[name='quantity']")
    private WebElement qty;

    @FindBy (css = ".adjustform.qty>input[value='Update']")
    private WebElement update;

    @FindBy (css = "#checkout_page_container .yourtotal .pricedisplay")
    private WebElement total;

    @FindBy (css= ".cart_icon .icon")
    private WebElement checkOutButton;


    public CheckOut_POF(WebDriver driver) {
        this.driver = driver;
    }

    public void updateQty(int q) {
        qty.clear();
        qty.sendKeys(Integer.toString(q));
        update.click();
    }

    public void navigateToCheckOut(){
        checkOutButton.click();
    }

    public void verifyTotal() {
        //total cost is the first element that is found; remove the $ sign
        String totalString = total.getText().replaceAll("[$,]", "");

        //convert total cost from String to Double
        Double totalCost = Double.parseDouble(totalString);
        System.out.println("The cost of all items is " + totalCost);

        //create a list that contains all elements related to product names
        List<WebElement> nameList = driver.findElements(By.cssSelector(".checkout_cart .wpsc_product_name"));

        //create a list that contains all elements related to quantity
        List<WebElement> quantityList = driver.findElements(By.cssSelector("#checkout_page_container .checkout_cart .product_row .adjustform.qty>input[name='quantity'] "));

        //create a list that contains all the elements related to price
        List<WebElement> priceList = driver.findElements(By.cssSelector("#checkout_page_container .checkout_cart .pricedisplay"));

        ListIterator<WebElement> iter = priceList.listIterator();

        for(int i=1; i<=priceList.size(); i++)
        {
            iter.next();
            if (i % 3 == 0) iter.remove();
        }

        //print the rows
        System.out.println("Total selected rows are " + quantityList.size());

        int sum = 0;
        double verifyPrice;
        double verifyTotalPrice = 0;

        for (int i=0;i<quantityList.size();i++){
            // get the quantity
            String name = nameList.get(i).getText();
            int quantity = Integer.parseInt(quantityList.get(i).getAttribute("value"));

            String priceString = priceList.get(i*2).getText().replaceAll("[$,]", "");

            Double price = Double.parseDouble(priceString);

            String totalPriceString = priceList.get(((i*2)+1)).getText().replaceAll("[$,]", "");

            Double totalPrice = Double.parseDouble(totalPriceString);

            // print the text
            System.out.print("Name is " + name);
            System.out.print("\t\t Quantity is " + quantity);
            System.out.print("\t\t Price is " + price);
            System.out.print("\t\t Total Price is " + totalPrice);
            System.out.println("");

            //calculate total quantity
            sum = sum + quantity;
            verifyPrice = quantity * price;
            System.out.println("\t\t Total Price verified is: " + verifyPrice);
            verifyTotalPrice = verifyTotalPrice + verifyPrice;
        }

        //print total quantity and total price
        System.out.println("Total quantity is " + sum);
        System.out.println("Total price: " + verifyTotalPrice);
    }
}
