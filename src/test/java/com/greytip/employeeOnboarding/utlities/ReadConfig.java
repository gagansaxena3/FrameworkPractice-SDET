package com.greytip.employeeOnboarding.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
		} 
		
		catch(Exception e) {
				System.out.println(e.getMessage());
					}
	}
		public String getApplicationURL() {
			String URL = pro.getProperty("baseURL");
			return URL;
		}
		
		
		public String getUserName() {
			String username = pro.getProperty("username");
			return username;
		}
		
		public String getPassword() {
			String password = pro.getProperty("password");
			return password;
		}
		
		public String getChromePath() {
			String chromepath = pro.getProperty("chromepath");
			return chromepath;
		}
		
		public String getFirefoxPath() {
			String firefoxpath = pro.getProperty("firefoxpath");
			return firefoxpath;
		}
	
	
		
	
}
