package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage_POF;
import pageObjects.LoginPage_POF;
import utility.Constant;
import utility.ExcelUtils;

import java.util.concurrent.TimeUnit;

public class FirstTest {

private static WebDriver driver;
    public static void main(String[] args) throws Exception {
        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");


        HomePage_POF homePage = PageFactory.initElements(driver, HomePage_POF.class);
        LoginPage_POF loginPage = PageFactory.initElements(driver,LoginPage_POF.class);
        homePage.navigateToMyAccount();


        //login using the username/pass from excel file
        ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData,"Sheet1");

        String sUsername = ExcelUtils.getCellData(1,1);
        String sPassword = ExcelUtils.getCellData(1,2);

        loginPage.login(sUsername,sPassword);

        ExcelUtils.setCellData("Passed",1,3);
        Thread.sleep(6000);

        driver.close();
        driver.quit();
    }
}
