package automationFramework;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.HomePage_POF;
import pageObjects.LoginPage_POF;
import utility.Constant;
import java.util.concurrent.TimeUnit;



/**
 * Created by FlavianDurigu on 3/28/2017.
 */
public class FirstTestTestNG {
    private WebDriver driver;
    private static Logger Log = Logger.getLogger(utility.Log.class.getName());

    //login to application using username and password that are located in testng.xml
    @org.testng.annotations.Test (priority = 0)
    @Parameters({"sUsername","sPassword"})
    public void login(){ //(String sUsername, String sPassword)



        DOMConfigurator.configure("log4j.xml");
        String title_homePage = driver.getTitle();
        Reporter.log("Application Launched successfully | ");


        Assert.assertEquals(title_homePage.toLowerCase()
                ,"online store | toolsqa dummy test site");

        HomePage_POF homePage = PageFactory.initElements(driver, HomePage_POF.class);
        LoginPage_POF loginPage = PageFactory.initElements(driver,LoginPage_POF.class);

        homePage.navigateToMyAccount();
        String title_myAccount = driver.getTitle();

        Assert.assertEquals(title_myAccount.toLowerCase()
                ,"your account | online store");

        loginPage.login(Constant.Username,Constant.Password);
        Log.info("User and Password entered ");
        Assert.assertTrue(loginPage.logOutButton.isDisplayed());

        Reporter.log("Sign In Successful | " );
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", Constant.Path_ChromeDriver);
        driver = new ChromeDriver();
        Log.info("New driver instantiated");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Implicit wait applied on the driver for 10 seconds");
        driver.get(Constant.URL_store);
        Log.info("Web application launched");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
        Log.info("Browser closed");
        Reporter.log("User is Logged out and Application is closed | ");
    }
}
