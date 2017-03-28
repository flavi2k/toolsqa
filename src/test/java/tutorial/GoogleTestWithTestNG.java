package tutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utility.Constant;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by FlavianDurigu on 3/28/2017.
 */
public class GoogleTestWithTestNG {

    public WebDriver driver;

    @BeforeMethod
    public void beforeM(){
        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", Constant.Path_ChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
    }


    //annotation to let TestNG know it is a test method
    @org.testng.annotations.Test
    public void testTitle() {


        // get the page's title
        String title = driver.getTitle();

        //verify that the title is 'google' by using TestNG Assert
        Assert.assertEquals("incorrect title"
                ,"Google"
                ,title); //actual

        //verification made using Fest Assert
        assertThat(title)
                .as("Google page's title") //a friendly name
                .isEqualToIgnoringCase("google"); //equal but ignoring case

        driver.close();
    }
}
