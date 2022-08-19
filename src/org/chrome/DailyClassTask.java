package org.chrome;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.netty.handler.codec.compression.Snappy;

public class DailyClassTask {
	public static WebDriver cdriver;

	public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shpra\\eclipse-workspace\\AChrome\\driver\\chromedriver.exe");  
		
	cdriver= new ChromeDriver();
	TakesScreenshot ss=(TakesScreenshot)cdriver;
	File  sorce = ss.getScreenshotAs(OutputType.FILE);
    
		


	}
	private void kumar() {
		// TODO Auto-generated method stub

	}

}
