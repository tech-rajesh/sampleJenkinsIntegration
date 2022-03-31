package appiumAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAutomation_RealDevice_Calculator {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		//device
		//application
		//appium server details
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "RajeshMachine");
		cap.setCapability("udid", "c60c1a73");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11.0");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//Get AppPackage and AppActivity
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//Target Application
		//AppPackage
		//AppActivity
		cap.setCapability("appPackage", "com.coloros.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void verifyAddFeature() throws Exception {
		
		System.out.println("launching calculator application.");
		
		//Press - 9 
		//Press - +
		//resourceID - id
		driver.findElement(By.id("com.coloros.calculator:id/digit_9")).click(); //9
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("digit_9")).click(); //9
		
		//99 + 87
		driver.findElement(By.id("op_add")).click(); //+
		
		driver.findElement(By.id("digit_8")).click(); //8
		driver.findElement(By.id("digit_7")).click(); //7
		
	}
	
	
	
	

}
