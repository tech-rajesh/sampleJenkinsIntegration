package appiumAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MobileAutomation_RealDevice_APK_Actions2 {
	
	AndroidDriver<AndroidElement> driver;
	AndroidTouchAction ta;
	
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
		
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}
	
	//@Test
	public void verifyTabFeatureOnOS() throws Exception {
		
		System.out.println("Installing application on real device");
		Thread.sleep(4000);
		
		AndroidTouchAction ta = new AndroidTouchAction(driver);
	
				
		MobileElement eleOS_accID = driver.findElementByAccessibilityId("OS");
		MobileElement eleOS_xpath = driver.findElementByXPath("//android.widget.TextView[@text='OS']");
		
		Thread.sleep(4000);
		//Tap operation
		ta.tap(ElementOption.element(eleOS_xpath)).perform();
		
		
		Thread.sleep(4000);
		
		
		
	}
	
	@Test
	public void verifySrollFeatureOnOS() throws Exception {
		
		System.out.println("Scrolling on real device");
		Thread.sleep(4000);
		
		ta = new AndroidTouchAction(driver);
	
		Thread.sleep(4000);
		AndroidElement eleView = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		ta.tap(ElementOption.element(eleView)).perform();
		Thread.sleep(4000);
		
		AndroidElement eleGallery = driver.findElementByXPath("//android.widget.TextView[@text='Gallery']");
		ta.tap(ElementOption.element(eleGallery)).perform();
		Thread.sleep(4000);
		
		AndroidElement elePhotos = driver.findElementByXPath("//android.widget.TextView[@text='1. Photos']");
		ta.tap(ElementOption.element(elePhotos)).perform();
		Thread.sleep(4000);
		
		
		//FirstPic
		AndroidElement elePic1 = driver.findElementsByClassName("android.widget.ImageView").get(0);
		System.out.println("---------Location----------");
		System.out.println(elePic1.getLocation());
		System.out.println(elePic1.getLocation().x);
		System.out.println(elePic1.getLocation().y);
		
		AndroidElement elePic3 = driver.findElementsByClassName("android.widget.ImageView").get(2);
		System.out.println("---------Location----------");
		System.out.println(elePic3.getLocation());
		System.out.println(elePic3.getLocation().x);
		System.out.println(elePic3.getLocation().y);
		
		ta.press(ElementOption.element(elePic1)).waitAction().moveTo(PointOption.point(1032,278)).release().perform();
		Thread.sleep(8000);
		//Tap operation
		//ta.tap(ElementOption.element(eleOS_xpath)).perform();
		
				
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(8000);
		System.out.println("Closing Application");
		driver.closeApp();
		
	}
	
	
	
	

}
