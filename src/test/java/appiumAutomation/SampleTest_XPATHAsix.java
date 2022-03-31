package appiumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest_XPATHAsix {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("launching Amazon app on chrome browser");
		driver.get("https://www.amazon.in/");
		
		
		
	}

	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		//driver.close();
		
	}
	
	@Test
	public void verifySearchTest() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		Thread.sleep(5000);
		
		String ProductName = driver.findElement(By.xpath("//span[text()='Apple iPhone 11 (64GB) - White']//ancestor::div[@class=\"sg-row\"]//descendant::a[contains(@class,'s-underline-text')]/span[contains(@class,'text-normal')]")).getText();
		String ProductPrice = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Blue']//ancestor::div[@class=\"sg-row\"]//descendant::span[@class=\"a-price\"]//child::span[contains(@class,'whole')]")).getText();
		String ProductPriceAttribute = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Blue']//ancestor::div[@class=\"sg-row\"]//descendant::span[@class=\"a-price\"]//child::span[contains(@class,'whole')]")).getAttribute("class");
		
		String ProductName1 = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Blue']//ancestor::div[@class=\"sg-row\"]//descendant::a[contains(@class,'s-underline-text')]/span[contains(@class,'text-normal')]")).getText();
		String ProductPrice1 = driver.findElement(By.xpath("//span[text()='Apple iPhone 11 (64GB) - White']//ancestor::div[@class=\"sg-row\"]//descendant::span[@class=\"a-price\"]//child::span[contains(@class,'whole')]")).getText();
		String ProductPriceAttribute1 = driver.findElement(By.xpath("//span[text()='Apple iPhone 11 (64GB) - White']//ancestor::div[@class=\"sg-row\"]//descendant::span[@class=\"a-price\"]//child::span[contains(@class,'whole')]")).getAttribute("class");
		
		
		System.out.println(ProductName);
		System.out.println("--------------------");
		System.out.println(ProductPrice + "---" + ProductPriceAttribute);
		System.out.println("--------------------");
		System.out.println(ProductName1);
		System.out.println(ProductPrice1 + "---" + ProductPriceAttribute1);
		
	}
	
}
