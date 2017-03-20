package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/20/2017.
 */
public class WebDriverCommands {

    private static WebDriver driver;
    private static String URL ="http://store.demoQA.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\\\KIT\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebDriver Commands - Browser Commands
        System.out.println("\t\tWebDriver Commands - Browser Commands");

        //navigate to URL
        driver.get(URL);

        //maximize the window
        driver.manage().window().maximize();

        //Practice exercise - 1
        System.out.println("\t\tBrowser Commands - Practice exercise - 1");

        //get title
        System.out.println("Title is: " + driver.getTitle());

        //get title length
        System.out.println("Title length is: " + driver.getTitle().length());

        //get current URL
        String actualURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + actualURL);

        if(actualURL.equalsIgnoreCase(URL)) {
            System.out.println("The correct URL is opened");
        }
        else {
            System.out.println("The URL is not correct");
        }
        //get source code
        String pageSource = driver.getPageSource();
        System.out.println("Total length of the Page Source is: " + pageSource.length());



        //Browser Commands - Practice exercise - 2
        System.out.println("\t\tBrowser Commands - Practice exercise - 2");

        /*driver.get("http://demoqa.com/frames-and-windows/");

        driver.findElement(By.xpath("./*//*[@id='tabs-1']/div/p/a")).click();
*/

        //WebDriver Commands - Browser Commands
        System.out.println("\t\tWebDriver Commands - Navigation Commands");

        //Navigation Commands - Practice exercise - 1
        System.out.println("\t\tNavigation Commands - Practice exercise - 1");

        driver.get("http://demoqa.com");
        driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();

        //navigate back
        System.out.println("Navigate back");
        driver.navigate().back();

        //navigate forward
        System.out.println("Navigate forward");
        driver.navigate().forward();

        //refresh browser
        System.out.println("Refresh browser");
        driver.navigate().refresh();


        //WebDriver Commands - CheckBox & Radio Button Operations
        System.out.println("\t\tWebDriver Commands - CheckBox & Radio Button Operations");

        driver.get("http://toolsqa.wpengine.com/automation-practice-form/");

        List<WebElement> radioButtonSex = driver.findElements(By.name("sex"));

        if(radioButtonSex.get(0).isSelected()) {
            radioButtonSex.get(1).click();
        }
        else {
            radioButtonSex.get(0).click();
        }

        WebElement radioButtonYears = driver.findElement(By.id("exp-2"));

        radioButtonYears.click();

        List<WebElement> checkProfession = driver.findElements(By.name("profession"));
        int iSize = checkProfession.size();
        for(int i = 0; i<iSize; i++){
            String sValue = checkProfession.get(i).getAttribute("value");
            if(sValue.equalsIgnoreCase("Automation Tester")) {
                checkProfession.get(i).click();
            }
        }

        WebElement chkAutoTool = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
        chkAutoTool.click();


        //WebDriver Commands - DropDown & Multiple Select Operations
        System.out.println("\t\tWebDriver Commands - DropDown & Multiple Select Operations");
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");


        //close current window
        System.out.println("Close window");
        //driver.close();

        //close all windows
       // driver.quit();








    }
}
