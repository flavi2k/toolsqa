package tutorial;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/23/2017.
 */
public class SwitchCommands {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        //parent window
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " +parentHandle);

        //WebElement newMsg = driver.findElement(By.cssSelector("[onclick='newMsgWin()']"));
        WebElement newMsg = driver.findElement(By.cssSelector("#button1"));
        newMsg.click();

        Set handles = driver.getWindowHandles();
        System.out.println("Handles: " +handles);

        //switch to second window (pop-up)
        for(String handle1:driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }

        //close pop up window
        driver.close();

        //back to first window
        driver.switchTo().window(parentHandle);

        //click AlertBox
        WebElement alertBox = driver.findElement(By.id("alert"));
        alertBox.click();

        Alert myAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        myAlert.accept();

        Thread.sleep(1000);

        //close original window
        driver.quit();
    }
}
