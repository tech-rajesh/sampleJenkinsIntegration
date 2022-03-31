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

public class DragDropExample {
	
	
	@Test
	public void dragdropTest1() throws Exception
	
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//frame - switching on frame 
		//index --- start from 0
		//name or id ------ name & id 
		//WebElement - control frame
		WebElement myFrame = driver.findElement(By.cssSelector(".demo-frame"));
		WebElement myFrame1 = driver.findElement(By.tagName("iframe"));
		
		//driver.switchTo().frame(0); //indexing
		//driver.switchTo().frame("name or id "); //name or id
		driver.switchTo().frame(myFrame);
		
		
		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement target = driver.findElement(By.cssSelector("div#droppable"));
		
		
		
		Actions act = new Actions(driver);
		//act.dragAndDrop(source, target).perform();
		
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, 
		//then releases the mouse.
		
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
