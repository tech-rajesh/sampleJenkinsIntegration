package appiumRealDeviceExample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RealDeviceChromeBrowser_AmazonTest {

	public static AppiumDriver<MobileElement> ad;

	@BeforeTest
	public void LaunchApp() throws IOException, Exception {
		// configuration

		// Devices - adb devices
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("udid", "c60c1a73"); // JSON
		cap.setCapability("deviceName", "RajeshMachine");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		// cap.setCapability("browserName", "Chrome");
		// cap.setCapability("noReset", true);

		// Set ChromeDriver location
		// System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver_99.exe");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidKeepAppDataDir", true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriverManager.chromedriver().setup();

		// Instantiate Appium Driver
		// AppiumDriver<MobileElement> driver = null;

//		try {
//			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//			
//		} catch (MalformedURLException e) {
//			System.out.println(e.getMessage());
//		}

		// APK file
		// cap.setCapability(MobileCapabilityType.APP,
		// "D:\\Jar_files\\appium\\APKFile\\ApiDemos-debug.apk");

		// Application
		// APK info
		// adb shell
		// adb shell dumpsys window | find "mCurrentFocus"

		// cap.setCapability("appPackage", "com.coloros.calculator");
		// cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Appium Server - IP details
		Thread.sleep(5000);
		ad = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void verifyAddTestWithThreeDigitNumber() throws Exception {

		Thread.sleep(5000);
		System.out.println("Launching Google Application on chrome browser.");

		// Open URL in Chrome Browser
		ad.get("https://opensource-demo.orangehrmlive.com/");

		Thread.sleep(5000);
		ad.findElement(By.id("txtUsername")).sendKeys("Admin");

		Thread.sleep(5000);
		// Name - password
		ad.findElement(By.name("txtPassword")).sendKeys("admin1234");

		Thread.sleep(5000);
		// ClassName - login button

		Thread.sleep(5000);
		ad.findElement(By.className("android.widget.Button")).click();

		Thread.sleep(5000);
		// LinkText - forgot password link
		ad.findElement(By.linkText("Forgot your password?")).click();

	}
	
	@AfterTest
	public void closeApp() {
		
		ad.quit();
	}

}
