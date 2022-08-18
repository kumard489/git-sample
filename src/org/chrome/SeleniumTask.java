package org.chrome;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.cd;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTask {
	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shpra\\eclipse-workspace\\AChrome\\driver\\chromedriver.exe");

		WebDriver cdriver = new ChromeDriver();
		
		
		cdriver.get("http://facebook.com");
		cdriver.manage().window().maximize();
		String title = cdriver.getTitle();
		String currentUrl = cdriver.getCurrentUrl();
		System.out.println(title + " : " + currentUrl);
		
		WebElement forgot = cdriver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		Actions act=new Actions(cdriver);
		act.moveToElement(forgot).contextClick().perform();
		Robot ro=new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		
		
		//5tab
		
		Set<String> allwin = cdriver.getWindowHandles();//12345
		List<String> all=new ArrayList<String>();
		all.addAll(allwin);
		
		for (int i = 0; i <all.size(); i++) {
			if (i==4) {
				String fourth = all.get(i);
				cdriver.switchTo().window(fourth);
			}
		}
		
		
		
		Thread.sleep(10000);
		cdriver.findElement(By.xpath("//button[text()='Search']")).click();
			
		//cdriver.close();
		
		
		
		
		
		
		
		
		
	}

}
