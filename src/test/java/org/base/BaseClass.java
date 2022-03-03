package org.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;

	public static void lanuchBrowser(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

	}

	public static void launchUrl(String url) {

		driver.get(url);
	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void setWaits() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void timeCapture() {
		Date d = new Date();
		System.out.println(d);

	}
	public static void takeSnap(String filePath, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File scr = new File(filePath+fileName);
		FileUtils.copyFile(temp, scr);
	}

}
