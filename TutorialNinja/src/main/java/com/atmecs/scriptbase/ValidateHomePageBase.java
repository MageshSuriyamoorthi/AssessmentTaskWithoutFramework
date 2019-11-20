package com.atmecs.scriptbase;

import org.openqa.selenium.WebDriver;

import com.atmecs.helper.ExcelReader;
import com.atmecs.helper.PropertyReader;
import com.atmecs.testbase.Classpaths;
import com.atmecs.utility.AssertionAndValidation;
import com.atmecs.utility.utils;

public class ValidateHomePageBase {
	utils util = new utils();
	ExcelReader excelreader = new ExcelReader();
	String actual, expected;
	AssertionAndValidation assertion = new AssertionAndValidation();
	PropertyReader reader = new PropertyReader();

	public void searchProduct(WebDriver driver, String text) {
		util.sendKeys(driver, reader.getLocatorValue("loc.search.tab"), text);
		util.click(driver, reader.getLocatorValue("loc.search.button"));
		util.scroll(driver);
		util.click(driver, reader.getLocatorValue("loc.getfirst.product"));
	}

	public void descriptionValidationAndAddingCart(WebDriver driver, int rowno) throws Exception {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("iPhone")) {
			actual = util.getText(driver, reader.getLocatorValue("loc.get.availability"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Availability", rowno);
			assertion.trueAssert(actual, expected, "Availability for iphone has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.get.price"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Price", rowno);
			assertion.trueAssert(actual, expected, "Price for iphone has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.get.etax"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "ET Tax", rowno);
			assertion.trueAssert(actual, expected, "ET Tax for iphone has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.description.text"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Description", rowno);
			assertion.trueAssert(actual, expected, "Description has been verified");
		} else {

			actual = util.getText(driver, reader.getLocatorValue("loc.get.macavailability"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Availability", rowno);
			assertion.trueAssert(actual, expected, "Availability for mac has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.get.price"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Price", rowno);
			assertion.trueAssert(actual, expected, "Price for macBook air has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.get.etax"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "ET Tax", rowno);
			assertion.trueAssert(actual, expected, "ET Tax for macBook has been verified");

			actual = util.getText(driver, reader.getLocatorValue("loc.description.text"));
			expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Description", rowno);
			assertion.trueAssert(actual, expected, "Description has been verified");

		}

	}
}
