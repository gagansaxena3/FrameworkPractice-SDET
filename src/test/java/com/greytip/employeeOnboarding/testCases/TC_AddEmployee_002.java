package com.greytip.employeeOnboarding.testCases;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.greytip.employeeOnboarding.pageObject.LoginPage;
import com.greytip.employeeOnboarding.utlities.ExcelUtils;
import com.mongodb.diagnostics.logging.Logger;

import junit.framework.Assert;

public class TC_AddEmployee_002 extends BaseClass {
	
	@Test(dataProvider="EmployeeData")
	public void AddEmployee(String EmpName, String EmailID) throws InterruptedException, IOException	{
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(5000);
		lp.setUserName(username);
		lp.setpassword(password);
		lp.clickSubmit();
		
		com.greytip.employeeOnboarding.pageObject.AddEmployee addemp = new com.greytip.employeeOnboarding.pageObject.AddEmployee(driver);
		
		//addemp.AddEmployeeAlertPopup();
		addemp.EmployeeIconClick();
		addemp.EmployeeMainClick();
		addemp.clickOnEmpDirectory();
		
		addemp.clickOnAddEmployee();
		addemp.selectEmpNumSeriesDropdown();
		addemp.selectManualEntry();
		logger.info("Selected EmployeeType");
		int empNumber = randomNum();
		
		addemp.enterEmployeeNumber(empNumber);
		System.out.println("Employee Number is :" +empNumber);
		addemp.enterEmployeeName(EmpName);
		logger.info("Employee Name is entered");
		
		addemp.selectgender();
		addemp.enterDOJ("29 Aug 2019");
		logger.info("Employee DOJ is entered");
		Thread.sleep(2000);
		
		addemp.clickOutsideToMakeCheckboxEnabled();
		logger.info("Clicked Outside");
		
		addemp.selectOnboardingcheckbox();
		logger.info("Selected Onboarding CheckBox");
		
		
		addemp.enterEmailID(EmailID);
		addemp.clickNextbutton();
		logger.info("First Page Next button is clicked");
		
		Thread.sleep(2000);
		addemp.selectLocation();
		logger.info("Selected employee location");
		
		addemp.clickNextbutton2();
		logger.info("Second Page Next button is clicked");
		Thread.sleep(2000);
		addemp.clickonNextbutton3();
		logger.info("Third Page Next button is clicked");
		Thread.sleep(2000);
		addemp.clickOnFinishButton();
		logger.info("Employee is added by select Finish button");
	
		addemp.EmployeeAddSuccessMessage();
		logger.info("Employee is added by verifying success message");
		Thread.sleep(2000);
		String EmpNo = addemp.getEmployeeNumber();
		System.out.println("Success Message Employee Number is:" +EmpNo);
	
		addemp.clickonSignOutButton();
		Thread.sleep(3000);
		
		Boolean signOutText =driver.getPageSource().contains("You have logged out successfully!"); 
			
		if (signOutText == true) {
			Assert.assertTrue(true);
			logger.info("Signout is successfull");
		}
		
		else {
			captureScreenshotForFailedTestCases("TC_LoginTest_001");
			Assert.assertTrue(false);
			logger.error("SignOut is failed");
		}
	}
			
		@DataProvider(name="EmployeeData")
		String [] [] getdata() throws IOException {
		
		String path = System.getProperty("user.dir") +"/src/test/java/com/greytip/employeeOnboarding/testData/EmployeeData.xls";
		
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		int colcount= ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String employeeName[][] = new String[rownum][colcount];
		
		for  ( int i=1; i<=rownum; i++) {
				for (int j=0; j<colcount; j++) {
					employeeName[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
				}
		}
		
		return employeeName;

		
	}
	
	
}
