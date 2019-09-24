package com.greytip.employeeOnboarding.pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 public LoginPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath=("//button[@type='submit']"))
	WebElement Submit;
	
	
	public void setUserName ( String uname) {
		username.sendKeys(uname);
	}
	
	public void setpassword ( String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		Submit.click();
	}
	
	
	
	
	
	
}
