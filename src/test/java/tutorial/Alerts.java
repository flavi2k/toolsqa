package tutorial;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/23/2017.
 */
public class Alerts {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");

        //simple alert
        driver.findElement(By.cssSelector("[onclick='pushAlert()']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("simple alert is: "+alertText);
        Thread.sleep(1000);
        simpleAlert.accept();

        //confirmation alert
        WebElement element = driver.findElement(By.cssSelector("[onclick='pushConfirm()']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String confirmationText = confirmationAlert.getText();
        System.out.println("Confirmation alert is: "+confirmationText);
        Thread.sleep(1000);
        confirmationAlert.dismiss();

        //prompt alerts
        WebElement element2 = driver.findElement(By.cssSelector("[onclick='promptConfirm()']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element2);
        Alert promptAlert = driver.switchTo().alert();
        String promptText = promptAlert.getText();
        System.out.println("Prompt alert is: "+promptText);
        promptAlert.sendKeys("");
        promptAlert.sendKeys("accepting the alert");
        Thread.sleep(1000);
        promptAlert.accept();

        driver.close();
        driver.quit();

    }
}
