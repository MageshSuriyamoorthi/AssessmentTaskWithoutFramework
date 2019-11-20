package com.atmecs.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utils {

	Logger log = Logger.getLogger(log4j.class.getName());

	public By locator(String locatorvalue) {
		By by = null;
		String[] locator = locatorvalue.split(":", 2);
		String locatorName = locator[0].toUpperCase();
		switch (locatorName) {
		case "ID":
			by = By.id(locator[1]);
			break;
		case "NAME":
			by = By.name(locator[1]);
			break;
		case "CLASSNAME":
			by = By.className(locator[1]);
			break;
		case "LINKEDTEXT":
			by = By.linkText(locator[1]);
			break;
		case "PARTIALLINKEDTEXT":
			by = By.partialLinkText(locator[1]);
			break;
		case "XPATH":
			by = By.xpath(locator[1]);
			break;
		case "CSS":
			by = By.cssSelector(locator[1]);
			break;
		default:
			log.info("enter correct locator");
		}
		return by;
	}

	public WebElement FindElement(WebDriver driver, String locator) {
		WebElement elememt = driver.findElement(locator(locator));
		return elememt;
	}

	public void geturl(WebDriver driver, String url) {
		driver.get(url);
		log.info("Url has been opened");
	}

	public void click(WebDriver driver, String locator) {
		FindElement(driver, locator).click();
	}

	public void clear(WebDriver driver, String locator) {
		FindElement(driver, locator).clear();
	}

	public void sendKeys(WebDriver driver, String locator, String text) {
		FindElement(driver, locator).sendKeys(text);
	}

	public void scroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void scrolltoview(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", FindElement(driver, locator));
	}

	public String getText(WebDriver driver, String locator) {
		WebElement element = FindElement(driver, locator);
		String getText = element.getText();
		return getText;
	}

}
