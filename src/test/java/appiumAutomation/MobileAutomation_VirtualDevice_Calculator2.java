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

public class MobileAutomation_VirtualDevice_Calculator2 {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		//device
		//application
		//appium server details
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		
		
		
		//Get AppPackage and AppActivity
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//Target Application
		//AppPackage
		//AppActivity
		cap.setCapability("appPackage", "com.dencreak.dlcalculator");
		cap.setCapability("appActivity", "com.dencreak.dlcalculator.DLCalculatorActivity");
		
		
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void verifyAddFeature() {
		
		System.out.println("launching calculator application.");
		
		driver.findElement(By.xpath("//android.widget.Button[@index='4']")).click(); 
		
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click(); 
		
	}
	
	
	
	

}
