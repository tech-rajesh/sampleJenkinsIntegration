package ctionExample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleExample {
	
	WebDriver driver;

	@Test
	public void verifyGoogleSearch() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("iphone");

		Thread.sleep(5000);

		// click on Return within 30days button
		WebElement BtnGoogleSearch = driver.findElement(By.name("btnK"));

		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click();", BtnGoogleSearch);

		Thread.sleep(5000);
		// TakeScreenshot
		
		//getScreenShot();

	}

	public void getScreenShot() throws Exception {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destlocation = new File("./screenshotFolder/GoogleSearchResult_method_testNGExample_23March_temp_1.png");

		FileUtils.copyFile(screenshotFile, destlocation);
	}

}
