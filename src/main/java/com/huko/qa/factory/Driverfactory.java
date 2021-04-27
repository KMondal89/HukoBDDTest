package com.huko.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.huko.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is used to provide Synchronised WebDriver.
 * 
 * @author CodeClouds-Kaustav
 *
 */

public class Driverfactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> thdlcldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			thdlcldriver.set(new ChromeDriver());

		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			thdlcldriver.set(new FirefoxDriver());

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			thdlcldriver.set(new EdgeDriver());
		}

		else {
			System.out.println("Please provide the correct browser" + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return thdlcldriver.get();
	}

}
