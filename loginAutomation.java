package main;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class loginAutomation {
	
	public static void joinClass() {
		
		ChromeOptions options =  new ChromeOptions();
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		contentSettings.put("notifications", 1);//Enabling Notifications
		contentSettings.put("media_stream", 1);//Auto-enabling Microphone and Webcam Access
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		variables var = new variables();//Creating object of class 'variables' to access various Strings
		
		driver.manage().window().maximize();//Maximise Chrome Window
		
		//Sign-in link
		driver.get(var.getSignIn());
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Entering Email address
		driver.findElement(By.xpath("//*[@id=\'identifierId\']")).sendKeys(var.getEmail());
		driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/div[2]")).click();
		
		//Entering Password
		driver.findElement(By.name("password")).sendKeys(var.getPassword());
		driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/div[2]")).click();
		
		//Clicking specific classroom in Google Classroom
		driver.findElement(By.xpath("//*[@id=\'yDmH0d\']/div[4]/div/div[2]/div/ol/li[2]/div[1]")).click();
		//Clicking meeting link
		driver.findElement(By.xpath("//*[@id=\'yDmH0d\']/div[4]/div[2]/div/div[1]/div/div[2]/div[2]/div/span/a/div")).click();
		
		driver.findElement(By.xpath("//*[@id=\'yDmH0d\']/c-wiz/div/div/div[9]/div[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/span/span")).click();
		
//		try {
//			Thread.sleep(3000);
//		} catch(InterruptedException e) {
//			
//		}
//		driver.findElement(By.className("ZB88ed")).click();
//		
//		try {
//			Thread.sleep(3000);
//		} catch(InterruptedException e) {
//			
//		}
//		driver.findElement(By.className("GOH7Zb")).click();
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
//		actions.moveByOffset(32, 32).click().build().perform();
	}

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		
		joinClass();
	}
}