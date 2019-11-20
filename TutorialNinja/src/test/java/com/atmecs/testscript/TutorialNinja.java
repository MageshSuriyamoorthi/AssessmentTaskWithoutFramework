package com.atmecs.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.helper.ExcelReader;
import com.atmecs.scriptbase.ValidateHomePageBase;
import com.atmecs.testbase.Classpaths;
import com.atmecs.testbase.TestBase;
import com.atmecs.utility.AssertionAndValidation;
import com.atmecs.utility.log4j;
import com.atmecs.utility.utils;

public class TutorialNinja extends TestBase {
	String actual, expected;
	utils util = new utils();
	ValidateHomePageBase base = new ValidateHomePageBase();
	ExcelReader excelreader = new ExcelReader();
	AssertionAndValidation assertandvalidate = new AssertionAndValidation();
	log4j log =new log4j(); 

	@BeforeMethod
	public void geturl() {
		util.geturl(driver, reader.getLocatorValue("url"));
		log.info("Url has been opened");
	}

	@Test
	public void searchProductAndAddingCart() throws Exception {
		base.searchProduct(driver, excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "SearchList", 1));

		log.info("To search product of Iphone has been entered");

		base.descriptionValidationAndAddingCart(driver, 1);

		log.info("To validating the first product its availability, price, tax and description");

		util.clear(driver, reader.getLocatorValue("loc.give.quantity"));

		log.info("Quantity box has been cleared for entering the number of products that were needed");

		util.sendKeys(driver, reader.getLocatorValue("loc.give.quantity"),
				excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Quantity", 1));

		log.info("To Enter the amount in the quantity box");

		util.click(driver, reader.getLocatorValue("loc.addtocart.select"));

		log.info("Clicked on add to cart button");

		util.clear(driver, reader.getLocatorValue("loc.search.tab"));

		log.info("Clearing the search tab button");

		base.searchProduct(driver, excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "SearchList", 2));

		log.info("Entering the second product data in the search box");

		base.descriptionValidationAndAddingCart(driver, 2);

		log.info("To validating the second product its availability, price, tax and description");

		util.clear(driver, reader.getLocatorValue("loc.give.quantity"));

		log.info("Quantity box has been cleared for entering the number of products that were needed");

		util.sendKeys(driver, reader.getLocatorValue("loc.give.quantity"),
				excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "Quantity", 2));

		log.info("To Enter the amount in the quantity box");

		util.click(driver, reader.getLocatorValue("loc.addtocart.select"));

		log.info("Clicked on add to cart button");

		util.click(driver, reader.getLocatorValue("loc.home.img"));

		log.info("Clicked on add to cart button");

		util.click(driver, reader.getLocatorValue("loc.cart.button"));

		log.info("Clicked on cart button");

		actual = util.getText(driver, reader.getLocatorValue("loc.firstproduct.price"));

		log.info("Getting actual price of the first product");

		expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "overallprice", 1);

		log.info("Getting expected price of the first product");

		assertandvalidate.trueAssert(actual, expected, "Overall price of Iphone is validated");

		actual = util.getText(driver, reader.getLocatorValue("loc.secondproduct.price"));

		log.info("Getting actual price of the second product");

		expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "overallprice", 2);

		log.info("Getting expected price of the second product");

		assertandvalidate.trueAssert(actual, expected, "Overall price of MacBook Air is validated");

		actual = util.getText(driver, reader.getLocatorValue("loc.overall.price"));

		log.info("Getting actual overall price of the product");

		expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "overallprice", 3);

		log.info("Getting expected overall price of the product");

		assertandvalidate.trueAssert(actual, expected, "Overall price of two products is validated");

		util.click(driver, reader.getLocatorValue("loc.delete.producttwo"));

		log.info("Clearing the second product");

		util.click(driver, reader.getLocatorValue("loc.home.img"));

		log.info("Cancelling the second product to get new price");

		util.click(driver, reader.getLocatorValue("loc.cart.button"));

		log.info("Clicking the cart button");

		actual = util.getText(driver, reader.getLocatorValue("loc.overall.price"));

		log.info("Getting actual overall price of the product");

		expected = excelreader.getdata(Classpaths.TestData_file, "TutorialNinja", "overallprice", 4);

		log.info("Getting expected overall price of the product");

		assertandvalidate.trueAssert(actual, expected, "When MacBook air is deleted the overall price is validated");

	}

}
