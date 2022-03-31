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
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class MobileAutomation_RealDevice_XPATH_InstalledAPP {
	
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
		cap.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\ApiDemos-debug.apk");
		
		//adb shell dumpsys window | find "mCurrentFocus"
		//cap.setCapability("appPackage", "io.appium.android.apis");
		//cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void verifyAddFeature() throws Exception {
		
		
		System.out.println("Installing application on real device");
		Thread.sleep(4000);
		
		
		//----------------------------------------------------------
		//className ----- TagName
		
		//Tagname[@att='value'] ----- valid xpath
		
		//driver.findElementByXPath("//android.widget.TextView[@index='8']").click();		
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		driver.findElementByXPath("//*[@text='Views']").click();
		
		
		
		
		
//		AndroidTouchAction ta = new AndroidTouchAction(driver);
//	
//				
//		MobileElement eleOS_accID = driver.findElementByAccessibilityId("OS");
//		MobileElement eleOS_xpath = driver.findElementByXPath("//android.widget.TextView[@text='OS']");
//		
//		Thread.sleep(4000);
//		//Tap operation
//		ta.tap(ElementOption.element(eleOS_xpath)).perform();
//		
//		
//		Thread.sleep(4000);
//		
		
	}
	
	
	
	

}
