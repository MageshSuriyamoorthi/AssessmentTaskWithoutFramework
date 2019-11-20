package com.atmecs.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.atmecs.testbase.Classpaths;

public class PropertyReader {
	List<String> filepath = Arrays.asList(Classpaths.Config_file, Classpaths.Locator_file);
	Properties prop = new Properties();

	public PropertyReader() {
		for (String files : filepath) {

			File file = new File(files);
			try {
				FileInputStream fileis = new FileInputStream(file);
				prop.load(fileis);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getLocatorValue(String elements) {
		String data = prop.getProperty(elements);
		return data;
	}

}
