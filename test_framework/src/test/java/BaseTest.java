import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Before test");
        //System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();// Object is created- Chrome browser is opened
        driver.manage().window().maximize();
        driver.get("https://google.com");

    }


    @AfterClass(alwaysRun = true)
    public void afterSuite() {
        System.out.println("After test");
        if(null != driver) {
            driver.close();
            try
            {
                driver.quit();
            }
            catch (Exception e)
            {
                System.out.println("Unable to close browser after login header exception caught: " + e);
            }
            driver.quit();
        }
    }



}


