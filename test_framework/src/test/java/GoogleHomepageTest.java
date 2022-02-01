import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GoogleHomepageTest extends BaseTest{
WebDriver getDriver = new ChromeDriver();
HomePageLocators locators = new HomePageLocators();

        @Test(groups = {"test1"} )
        public void a_verifyTitle() {
            driver.get("https://www.google.com");
            String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Google";
            Assert.assertEquals(ActualTitle, ExpectedTitle);
            System.out.println("Assert Passed");
        }
        @Test(groups = {"test2"})
        public void b_typeInSearchField(){
            locators.getSearchField().sendKeys("Ducks");
        }
        @Test(groups = {"test3"})
    public void c_clickSearch(){
            locators.getClickSearchBtn().click();

        }



}
