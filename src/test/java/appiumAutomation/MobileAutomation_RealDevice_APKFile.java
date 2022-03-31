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

public class MobileAutomation_RealDevice_APKFile {
	
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
		
		//Installing Application
		cap.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\appium\\APKFile\\ApiDemos-debug.apk");
		
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void verifyAddFeature() throws Exception {
		
		System.out.println("Installing application on real device");
		
		
		
	}
	
	
	
	

}
