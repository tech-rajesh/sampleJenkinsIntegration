package appiumRealDeviceExample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class RealDeviceCalculator {
	
	AppiumDriver<MobileElement> ad;
	
	@BeforeTest
	public void LaunchApp() throws IOException {
		//configuration
		
		//Devices - adb devices
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("udid", "c60c1a73"); 					//JSON
		cap.setCapability("deviceName", "RajeshMachine");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("platformVersion", "11.0");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		
		//Application
		//APK info
		//adb shell
		//adb shell dumpsys window | find "mCurrentFocus"
		
		cap.setCapability("appPackage", "com.coloros.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		//Appium Server - IP details
		
		ad = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}
	
	

	@Test
	public void verifyAddTestWithThreeDigitNumber() throws Exception {
		
		Thread.sleep(5000);
		System.out.println("launching calculator application");
		
		//entered - 989
		//ID 
		ad.findElement(By.id("com.coloros.calculator:id/digit_9")).click();  		//click on 9
		Thread.sleep(1000);
		ad.findElement(By.id("com.coloros.calculator:id/digit_8")).click();			//click on 8
		Thread.sleep(1000);
		ad.findElement(By.id("digit_9")).click();									//click on 9
		
		
		//operation - add
		ad.findElement(By.id("op_add")).click();				//click on "+" button	
		
		//entered - 786
		ad.findElement(By.id("com.coloros.calculator:id/digit_7")).click();  		//click on 7
		Thread.sleep(1000);
		ad.findElement(By.id("com.coloros.calculator:id/digit_8")).click();			//click on 8
		Thread.sleep(1000);
		ad.findElement(By.id("digit_6")).click();									//click on 6
		Thread.sleep(1000);
		
		////operation - Equal
		ad.findElement(By.id("com.coloros.calculator:id/eq")).click();				//click on "=" button
		
		Thread.sleep(4000);
		
		//Fetch the Results
		String acutalResult = ad.findElement(By.id("com.coloros.calculator:id/result")).getText();
		System.out.println("Addition of 3 digit number : " + acutalResult);
		
		//Validate Results
		
		Assert.assertEquals(acutalResult, "1,775", "Validation get failed.");
		
		
		
	}
	
	
}
