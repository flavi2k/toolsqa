package tutorial.junits;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/27/2017.
 */
public class JunitBasics {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClassTest(){
        System.out.println("This code is executed once, at the start of the test run ");
        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }

    @Before
    public  void beforeTest() {
        System.out.println("This code is executed BEFORE each and every test.");
    }

    @Test
    public void testOne() {
        System.out.println("This is test one!");
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action.dragAndDrop(from,to).build().perform();

    }

    @Test
    public void testTwo(){
        System.out.println("this is test two!");
    }
    @Test
    public void testThree()
    {
        System.out.println("This is test three!");
    }
    @After
    public void afterTest()
    {
        System.out.println("This code is executed AFTER each and every test.");
    }
    @AfterClass
    public static void afterClassTest()
    {
        System.out.println("This code is executed once, at the end of the test run");
    }
}
