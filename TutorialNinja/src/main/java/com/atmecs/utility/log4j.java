package com.atmecs.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.testbase.Classpaths;

public class log4j {
	Logger logger = null;

	public log4j() {
		getlogger();
		logger = Logger.getLogger(log4j.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(Classpaths.Log4j_file);
	}

	public String info(String message) {
		logger.info(message);
		return message;
	}
}
