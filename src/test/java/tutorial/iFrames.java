package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/24/2017.
 */
public class iFrames {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/iframe-practice-page/");

        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
        for(WebElement el:iframeElements){
            System.out.println("iframe name: "+el.getAttribute("name") + "\tiframe id: " +el.getAttribute("id"));
        }

        //switch to frame by index
        driver.switchTo().frame(0);

        //switch to default frame
        driver.switchTo().defaultContent();

        //switch to frame by name or id
        driver.switchTo().frame("IF1");
        driver.findElement(By.id("exp-1")).click();

        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
