package com.atmecs.utility;

import org.testng.Assert;

public class AssertionAndValidation {
	log4j log=new log4j();
	
	public void trueAssert(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected);
		log.info(message);
	}

}
