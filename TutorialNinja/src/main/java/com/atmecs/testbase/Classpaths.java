package com.atmecs.testbase;

import java.io.File;

public class Classpaths {

	public static String systemPath = System.getProperty("user.dir");

	public static String resourceFile = systemPath + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources";

	public static String Chrome_file = systemPath + File.separator + "lib" + File.separator + "chromedriver.exe";

	public static String Firefox_file = systemPath + File.separator + "lib" + File.separator + "geckodriver.exe";

	public static String IE_file = systemPath + File.separator + "lib" + File.separator + "IEDriverServer.exe";

	public static String Config_file = systemPath + File.separator + "config.properties";

	public static String Locator_file = resourceFile + File.separator + "locator" + File.separator
			+ "TutorialNinja.properties";
	
	public static String Log4j_file = resourceFile + File.separator + "log4j" + File.separator
			+ "log4j.properties";

	public static String TestData_file = resourceFile + File.separator + "testdata" + File.separator + "TutorialNinjaTD.xlsx";
}