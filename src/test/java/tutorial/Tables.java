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
public class Tables {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.wpengine.com/automation-practice-table");

        String sRow = "1";
        String sCol="2";

        String sCellValue =
                driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println(sCellValue);

        String sRowValue = "Clock Tower Hotel";

        //First loop will find the 'ClOCK TOWER HOTEL' in the first column
        for (int i=1;i<=5;i++){
            String sValue = null;
            sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
            if(sValue.equalsIgnoreCase(sRowValue)){
                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                for (int j=1;j<=5;j++){
                    String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                    System.out.println(sColumnValue);
                }
                break;
            }
        }

        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
