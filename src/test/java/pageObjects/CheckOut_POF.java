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

        String[] totalPriceArray= new String[quantityList.size()];
        String[] priceArray = new String[quantityList.size()];
        int it = 0;

        //priceArray contains the price of each item
        for (int i=0; i<priceList.size();i+=3) {
            System.out.println("priceArray (" + i + ")= " + priceList.get(i).getText());
            priceArray[it] = priceList.get(i).getText();
            it++;
        }

        it=0;
        //totalPriceArray contains the total price of each item (quantity * price)
        for (int i=1; i<priceList.size();i+=3) {
            System.out.println("totalPriceArray (" + i + ")= " + priceList.get(i).getText());
            totalPriceArray[it] = priceList.get(i).getText();
            it++;
        }

        String[] priceString =new String[quantityList.size()];

        Double[] price = new Double [quantityList.size()];

        String[] totalPriceString = new String [quantityList.size()];

        Double[] totalPrice = new Double[quantityList.size()];

        //print the number of rows
        System.out.println("Total rows: " + quantityList.size());

        int sum = 0;
        double verifyPrice;
        double verifyTotalPrice = 0;

        for (int i=0;i<quantityList.size();i++){
            // get the quantity
            String name = nameList.get(i).getText();
            int quantity = Integer.parseInt(quantityList.get(i).getAttribute("value"));

            System.out.println("_____________________");
            System.out.print("\tQuantity [" + i + "]= " + quantity);
            System.out.print("\tpriceArray [" + i + "]= " + priceArray[i]);
            System.out.print("\ttotalPriceArray [" + i + "]= " + totalPriceArray[i]+"\n");
            System.out.println("_____________________");

            priceString[i] = priceArray[i].replaceAll("[$,]", "");
            price[i] = Double.parseDouble(priceString[i]);
            totalPriceString[i] = totalPriceArray[i].replaceAll("[$,]", "");
            totalPrice[i] = Double.parseDouble(totalPriceString[i]);

            // print
            System.out.print("Name: " + name);
            System.out.print("\t\t Quantity: " + quantity);
            System.out.print("\t\t Price: " + price[i]);
            System.out.print("\t\t Total Price: " + totalPrice[i]);
           // System.out.println("");

            //calculate total quantity
            sum = sum + quantity;
            verifyPrice = quantity * price[i];
            System.out.println("\t\t Total Price verified: " + verifyPrice);
            verifyTotalPrice = verifyTotalPrice + verifyPrice;
        }

        //print total quantity and total price
        System.out.println("Total quantity: " + sum);
        System.out.println("Total price: " + verifyTotalPrice);
    }
}
