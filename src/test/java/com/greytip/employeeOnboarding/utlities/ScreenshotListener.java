package com.greytip.employeeOnboarding.utlities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.greytip.employeeOnboarding.testCases.BaseClass;

public class ScreenshotListener extends BaseClass {

			public ScreenshotListener() throws IOException {
			super();
			
		}

		public void onTestStart(ITestResult result) {
			
			
		}

		public void onTestSuccess(ITestResult result) {
			
			
		}
		public void onTestFailure(ITestResult result) throws IOException {
			System.out.println("FAILED TEST METHODS");
			captureScreenshotForFailedTestCases(result.getMethod().getMethodName());
			
		}
		

	

		public void onTestSkipped(ITestResult result) {
			
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
			
		}

		public void onStart(ITestContext context) {
			
			
		}

		public void onFinish(ITestContext context) {
			
			
		}

	}

	
	

