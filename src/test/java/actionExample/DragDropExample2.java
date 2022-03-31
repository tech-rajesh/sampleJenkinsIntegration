package actionExample;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropExample2 {
	
	
	@Test
	public void dragdropTest1()
	
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		//frame - switching on frame 
		//index --- start from 0
		//name or id ------ name & id 
		//WebElement - control frame
		//WebElement myFrame = driver.findElement(By.cssSelector(".demo-frame"));
		WebElement myFrame1 = driver.findElement(By.xpath("//iframe[contains(@data-src,\"photo-manager\")]"));
		
		//driver.switchTo().frame(0); //indexing
		//driver.switchTo().frame("name or id "); //name or id
		driver.switchTo().frame(myFrame1);
		
		
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		Actions act = new Actions(driver);
		
		//method1
//		act.dragAndDrop(img3, trash).perform();
//		act.dragAndDrop(img4, trash).perform();
		
		
		
		
		//method2
		
		
		act.clickAndHold(img3).moveToElement(trash).release().build().perform();	
		act.clickAndHold(img4).moveToElement(trash).release().build().perform();		
		
		//act.dragAndDrop(source, target).perform();
		
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, 
		//then releases the mouse.
		
		//act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		
	}

}
