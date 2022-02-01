

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.sql.DriverManager.getDriver;

public class HomePageLocators {
   WebDriver driver;

   public  WebElement getSearchField() {

        return driver.findElement(By.xpath("//input[@name='q']"));

         }
    public  WebElement getClickSearchBtn() {

        return driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));

    }

}
