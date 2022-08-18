package org.chrome;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MyProject {
	public static WebDriver cdriver;
	public static Actions action;
	public static Robot robot;
	public static void booking() throws AWTException, InterruptedException{
		//booking hotel
				//Destination
				WebElement destination = cdriver.findElement(By.xpath("//input[contains(@placeholder,'Where would ')]"));
				destination.sendKeys("ecr");
				Thread.sleep(2000);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				//Selecting dates 
				//Check-in
				WebElement strtDate = cdriver.findElement(By.xpath("(//div[text()='28'])[1]"));
				action.moveToElement(strtDate).click().perform();
				Thread.sleep(2000);
				//Check-out
				WebElement endDate = cdriver.findElement(By.xpath("(//div[text()='31'])[1]"));
				action.moveToElement(endDate).click().perform();
				Thread.sleep(2000);
				//Guests
				cdriver.findElement(By.xpath("(//div[@class='guest-picker'])")).click();
				Thread.sleep(2000);
				//Room
				WebElement room = cdriver.findElement(By.xpath("(//span[text()='Increase'])[1]"));
				action.moveToElement(room).click().perform();
				Thread.sleep(2000);
				//Adults
				WebElement adults = cdriver.findElement(By.xpath("(//span[text()='Increase'])[2]"));
				action.moveToElement(adults).doubleClick().perform();
				Thread.sleep(2000);
				//Children
				WebElement children = cdriver.findElement(By.xpath("(//span[text()='Increase'])[3]"));
				action.moveToElement(children).doubleClick().click().build().perform();
				Thread.sleep(2000);
				//done
				cdriver.findElement(By.xpath("//span[text()='Done']")).click();
				Thread.sleep(2000);
				//Find a hotel
				WebElement findAHotel = cdriver.findElement(By.xpath("(//button[@type='submit'])[1]"));
				action.moveToElement(findAHotel).click().perform();
				//Thread.sleep(10000);
				//access denied
	}
	
	public static void screenshot(String snap) throws IOException {
		TakesScreenshot ss=(TakesScreenshot)cdriver;
		File sorce = ss.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\shpra\\eclipse-workspace\\AChrome\\projectss\\"+snap+".jpg");
		FileUtils.copyFile(sorce, destination);
	}
	
	public static void usingJavaScript() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)cdriver;
		//signin
		WebElement signin = cdriver.findElement(By.xpath("//span[text()='Sign in']"));
		js.executeScript("arguments[0].click()", signin);
		Thread.sleep(2000);
		//username
		WebElement username = cdriver.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('value','faff@gmail.com')", username);
		//password
		WebElement password = cdriver.findElement(By.id("password"));
		js.executeScript("arguments[0].setAttribute('value','sdaf@123214l')", password);
		//login
		WebElement login = cdriver.findElement(By.xpath("//span[text()='Sign In']"));
		js.executeScript("arguments[0].click()", login);
	} 
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shpra\\eclipse-workspace\\AChrome\\driver\\chromedriver.exe");
		
	    ChromeOptions options=new ChromeOptions();
	    //options.addArguments("--incognito");
	    options.addArguments("--start-maximized");
	    //options.addArguments("--disable-infobars");//it dose not work
		//options.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension)"));
	    
		cdriver = new ChromeDriver(options);
		//cdriver.manage().window().maximize();
		cdriver.get("https://www.hotwire.com/");

		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);
		
		//action class using in my project
		action = new Actions(cdriver);
		//robot class using in my project
		robot = new Robot();
        
		//calling javascriptexecutor method
		usingJavaScript();
		
		cdriver.getWindowHandle();
		
		
		cdriver.quit();
		
		
	}

}
