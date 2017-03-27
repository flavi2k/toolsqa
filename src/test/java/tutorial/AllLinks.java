package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by FlavianDurigu on 3/27/2017.
 */
public class AllLinks {

    private static WebDriver driver;


    public static void main(String[] args) {

        String workingDir = System.getProperty("user.dir");
        System.out.println("working directory: "+ workingDir);
        System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/automation-practice-form/");

        //all Links on a Webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("There are "+links.size()+" links on page");


        //all CheckBoxes on a Webpage
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("There are "+checkboxes.size()+" checkboxes on page: ");
        for(int i =0; i<checkboxes.size(); i++){
            System.out.println("\t\t"+checkboxes.get(i).getAttribute("name")+
            "\t\t"+checkboxes.get(i).getAttribute("value"));
                    }

        //all RadioButtons on a Webpage
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("There are "+radioButtons.size()+" radiobuttons on page: ");
        for(int i =0; i<radioButtons.size(); i++){
            System.out.println("\t\t"+radioButtons.get(i).getAttribute("name")+
                    "\t\t"+radioButtons.get(i).getAttribute("value"));
        }

        //!!!!!IMPORTANT!!!
        // all DropDowns and multiple select elements on a Webpage
        List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
        System.out.println("There are "+dropdowns.size()+" dropdowns on page: ");
        for(int i=0;i<dropdowns.size();i++){
            //get the ids and names of the drop downs
            String ids = dropdowns.get(i).getAttribute("id");
            String names = dropdowns.get(i).getAttribute("name");
            //print the name of the dropdowns
            System.out.println(names.toUpperCase());

            //create a new element for each dropdown element
            WebElement dropDownElement = driver.findElement(By.id(ids));

            //!!!!find an element using the parent element as starting point
            //create a list of options for each dropdown
            List<WebElement> options = dropDownElement.findElements(By.tagName("option"));
            for(int j=0; j<options.size();j++){
                System.out.println("\t\t"+options.get(j).getText());
            }
        }

        //all TextBoxes
        List<WebElement> textboxes = driver.findElements(By.xpath("//input[@type='text']"));
        System.out.println("There are "+textboxes.size()+" textboxes on page");

        driver.close();
        driver.quit();
    }

}
