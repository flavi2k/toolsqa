package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/22/2017.
 */
public class RadioButton_CheckBox {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.wpengine.com/automation-practice-form");

        List<WebElement> oRadio = driver.findElements(By.name("exp"));

        oRadio.get(oRadio.size()-4).click();

        System.out.println("The following radio buttons are present in the list: ");
        for (int i = 0; i<oRadio.size(); i++) {
            if(oRadio.get(i).isSelected()) {
                System.out.println("\t\t^" + oRadio.get(i).getAttribute("value") + " (selected)");
            }
            else {
                System.out.println("\t\t" + oRadio.get(i).getAttribute("value"));
            }
        }

        List<WebElement> oCheckBox = driver.findElements(By.name("tool"));
        oCheckBox.get(0).click();
        oCheckBox.get(1).click();
        System.out.println("The following radio buttons are present in the list: ");
        for (int i = 0; i<oCheckBox.size(); i++) {
            if(oCheckBox.get(i).isSelected()) {
                System.out.println("\t\t^" + oCheckBox.get(i).getAttribute("value") + "(selected)");
            }
            else {
                System.out.println("\t\t" + oCheckBox.get(i).getAttribute("value"));
            }
        }
    }
}
