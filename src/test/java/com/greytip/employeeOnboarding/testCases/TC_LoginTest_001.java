package com.greytip.employeeOnboarding.testCases;
import com.greytip.employeeOnboarding.pageObject.LoginPage;
import junit.framework.Assert;
import java.io.IOException;
import org.testng.annotations.Test;


	public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws IOException, InterruptedException  {
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		LoginPage lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.setUserName(username);
		
		logger.info("Username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		
		lp.clickSubmit();
		logger.info("Logged into application");
		
		
					if (driver.getTitle().equals("greytHR IDP")) {
							Assert.assertTrue(true);
							logger.info("Homepage title is matched");
		}
					else {
							captureScreenshotForFailedTestCases("TC_AddEmployee_002");
							Assert.assertTrue(false);
							logger.info("Homepage title  is not matched");
		}
				
					
					
					
}

}
