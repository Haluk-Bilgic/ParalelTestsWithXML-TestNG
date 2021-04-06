package Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deneme.javaScriptExecuter;

public class ParalelTest {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Program Files/selenium/chromeDriver/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:/Program Files/selenium/firefoxDriver/geckodriver.exe");
		driver=new FirefoxDriver();
		}
		
		wait=new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	
	}
	@Test
	public void Test1() throws InterruptedException{
		Actions action=new Actions(driver);
		
		List<WebElement> menubar=driver.findElements(By.cssSelector(".sf-menu >li"));
		
		action.moveToElement(menubar.get(0)).perform();
	
		WebElement casualdress=driver.findElement(By.xpath("(//a[text()='Casual Dresses'])[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(casualdress));// burada casualdress gözükene kadar bekle dedik.
		
		casualdress.click();
		
		driver.findElement(By.cssSelector(".icon-th-list")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".button.lnk_view ")).click();
		Thread.sleep(2000);
 
		JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement element=driver.findElement(By.cssSelector("#thumbs_list_frame"));
        js.executeScript("arguments[0].scrollIntoView();",element);
		
		List<WebElement> images=driver.findElements(By.cssSelector("#thumbs_list_frame>li"));
		
		for(int i=0;i<images.size();i++){
			action.moveToElement(images.get(i)).perform();
			
			Thread.sleep(2000);
		}
		driver.findElement(By.cssSelector("#wishlist_button")).click();
		Thread.sleep(2000);
		WebElement loginMessage=driver.findElement(By.cssSelector(".fancybox-error"));
		
		wait.until(ExpectedConditions.visibilityOf(loginMessage));
		
	   Assert.assertEquals(loginMessage.getText(),"You must be logged in to manage your wishlist.");
		
		System.out.println(loginMessage.getText());
	}
	@AfterClass
	public void quit() throws InterruptedException{
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
