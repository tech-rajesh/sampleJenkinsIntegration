package ctionExample;


//import org.junit.jupiter.api.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonTest {


  @Test
  public void verifySearch() throws InterruptedException {

      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("https://www.amazon.in/");
      driver.manage().window().maximize();

      Thread.sleep(5000);



      WebElement SignInLink = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));

      //Actions -

      WebElement wishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));



      Actions act = new Actions(driver);

      act.moveToElement(SignInLink).moveToElement(wishList).click().build().perform();

      Thread.sleep(5000);

      String appURL = driver.getCurrentUrl();
      System.out.println(appURL);

  }






}
