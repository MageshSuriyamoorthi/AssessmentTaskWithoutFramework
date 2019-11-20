package com.atmecs.utility;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertionAndValidation {
	Logger log = Logger.getLogger(log4j.class.getName());

	public void trueAssert(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected);
		log.info(message);
	}

}
