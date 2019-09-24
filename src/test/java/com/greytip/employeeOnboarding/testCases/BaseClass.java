package com.greytip.employeeOnboarding.testCases;


import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.greytip.employeeOnboarding.utlities.ReadConfig;

import net.bytebuddy.utility.RandomString;


public class BaseClass {
	
	/**
	 *
	 * @author Gagan
	 */

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username =readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	
	public static Logger logger ;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String WebBrowser) {
		
		logger = Logger.getLogger("EmployeeOnboarding");
		PropertyConfigurator.configure("log4j.properties");
		
		if (WebBrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			} 
			else if(WebBrowser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				driver = new FirefoxDriver();
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshotForFailedTestCases(String testCaseName ) throws IOException {
		
		TakesScreenshot ts= 	(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/Screenshots/"+testCaseName+".png");
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot Taken");
	}
		
		
		public void waitForElement(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
		public static int randomNum() {
			Random random = new Random();
			int generatedNum= random.nextInt(254963);
			return generatedNum;
			
		}
	
	
	
	
	
}
