package com.atmecs.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.helper.PropertyReader;

public class TestBase {
	String browserName = null;

	public WebDriver driver;
	public PropertyReader reader = new PropertyReader();

	@BeforeClass
	public void driverInitialization() {
		browserName = (reader.getLocatorValue("browser").toUpperCase());
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Classpaths.Chrome_file);
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", Classpaths.Firefox_file);
			driver = new FirefoxDriver();
			break;
		case "INTERNET EXPLORER":
			System.setProperty("webdriver.ie.driver", Classpaths.IE_file);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver(ieCapabilities);
			break;
		default:
			System.out.println("give correct browser");
		}
		driver.manage().window().maximize();
	}

	@AfterClass
	public void driverClose() {
		driver.close();
	}
}
