package weather;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class weather {
	//Global variable for webdriver
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException{
			WebDriverManager.chromedriver().setup();
			init();
			myWeather();
			close();
	}
	
		public static void init() throws InterruptedException{
	        // Launch the URL
			driver = new ChromeDriver();
	      	driver.get("https://weather.gc.ca/forecast/canada/index_e.html?id=NS");
	      	driver.manage().window().maximize();
		}
	
		public static void myWeather() throws IOException, InterruptedException{
			//WebDriver driver = new ChromeDriver();
	      	//driver.get("https://weather.gc.ca/forecast/canada/index_e.html?id=NS");
	      	//driver.manage().window().maximize();
			
	        // Click on the "Halifax (Shearwater)" link
	        driver.findElement(By.linkText("Halifax (Shearwater)")).click();
	        Thread.sleep(1000L);
	        
	        //Go back to the Local Forecasts page
	        driver.findElement(By.linkText("Local forecasts")).click();
	        Thread.sleep(1000L);
	        
	        //Select PEI
	        driver.findElement(By.xpath("//a[@title='Prince Edward Island']")).click();
	        Thread.sleep(1000L);
	        
	        //Select Charlottetown
	        driver.findElement(By.linkText("Charlottetown")).click();
	        Thread.sleep(1000L);
	        
	        //Quit the driver
	        /*driver.quit();
	        Thread.sleep(2000L);
	        System.out.println("Success");*/
	}

		public static void close() throws IOException, InterruptedException{
			//Tell Selenium to take screenshot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);				
			//Save the file to your computer
			FileUtils.copyFile(scrFile, new File("ScreenShot.jpeg"));
			// Sleep just so it doesn't close so fast.
			Thread.sleep(2000L);	
			driver.quit();
			System.out.println("Success");
		}
		
		
}
