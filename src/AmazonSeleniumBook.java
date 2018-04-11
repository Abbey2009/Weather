import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonSeleniumBook {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		
		driver.get("https://amazon.ca");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		driver.findElement(By.linkText("See All 26 Departments")).click();
		
		//driver.close();
	}
}
