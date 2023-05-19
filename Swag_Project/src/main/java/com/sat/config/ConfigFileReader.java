package com.sat.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import com.sat.testbase.TestBase;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/sat/config/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public void refresh() {
		TestBase.getDriver().navigate().refresh();
	}

	public String fileUpload(String fileName) {
		String file_Name = properties.getProperty(fileName);
		if (file_Name != null)
			return file_Name;
		else
			throw new RuntimeException("File path not Specified in the configuration path");
	}

	
	
	public String getSwagHomeUrl(String Home_url) {
		
		String url = properties.getProperty(Home_url);
		System.out.println(Home_url);
		System.out.println(url);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getSwagHomeuserId(String user1) {
		String url = properties.getProperty(user1);
		System.out.println(user1);
		System.out.println(url);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getSwagHomepassword(String password) {
		String Password = properties.getProperty(password);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	
	
	
}
