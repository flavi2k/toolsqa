package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/22/2017.
 */
public class DropDown_MultipleSelect {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.wpengine.com/automation-practice-form");

        Select oSelect = new Select(driver.findElement(By.name("continents")));
        oSelect.selectByIndex(2);
        oSelect.selectByVisibleText("Australia");

        List<WebElement> oSize = oSelect.getOptions();
        String selectedElement ="";

        System.out.println("The following continents are present in the list: ");
        for (int i=0; i<oSize.size(); i++) {

            if(oSize.get(i).isSelected()) {
                selectedElement = oSize.get(i).getText();
                System.out.println("\t\t^" + oSize.get(i).getText()+" (selected)");
            }
            else {
                System.out.println("\t\t" + oSize.get(i).getText());
            }
        }
        //System.out.println("\nThe continent " + selectedElement + " is selected \n");


        Select oMultipleSelects = new Select(driver.findElement(By.id("selenium_commands")));
        oMultipleSelects.selectByIndex(3);
        Thread.sleep(1000);
        oMultipleSelects.selectByIndex(0);
        Thread.sleep(1000);
        oMultipleSelects.selectByVisibleText("Switch Commands");
        Thread.sleep(1000);
        oMultipleSelects.selectByIndex(0);
        Thread.sleep(1000);
        oMultipleSelects.deselectByIndex(3);

        List<WebElement> oMultipleSize = oMultipleSelects.getOptions();

        System.out.println("The following commands are present in the list: ");
        for(int i = 0; i<oMultipleSize.size();i++){
            if(oMultipleSize.get(i).isSelected()) {
                System.out.println("\t\t^" + oMultipleSize.get(i).getText() + " (selected)");
            }
            else {
                System.out.println("\t\t"+oMultipleSize.get(i).getText());
            }
        }

        System.out.println("Deselect all elements");
        oMultipleSelects.deselectAll();
        System.out.println("No elements are selected");

    }
}
