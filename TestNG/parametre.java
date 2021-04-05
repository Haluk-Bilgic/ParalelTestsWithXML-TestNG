package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametre {
	WebDriver driver;
	
	@Test
	@Parameters({"firstname","lastname","email"})
	 public void info(String firstname,String lastname,String email) throws InterruptedException{
		
System.setProperty("webdriver.chrome.driver","C:/Program Files/selenium/chromeDriver/chromedriver.exe");
		
		driver=new ChromeDriver();
			driver.get("http://www.tutorialsninja.com/demo/index.php?route=common%2Fhome");
driver.manage().window().maximize();

WebElement account=driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
	account.click();
	Thread.sleep(1000);
	WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
	register.click();
		
	driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys(firstname);
	
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	
	driver.findElement(By.xpath("(//input[@class='form-control'])[3]")).sendKeys(email);
	
	
	}
	@AfterClass
	public void quitt() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
