package com.greytip.employeeOnboarding.pageObject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.greytip.employeeOnboarding.testCases.BaseClass;

public class AddEmployee extends BaseClass  {
	
	public AddEmployee(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='pushActionRefuse']")
	private WebElement Alertpopup;
	
	@FindBy(xpath= "//div[@class='nav-menu-tooltip-outer'][contains(text(),'Employee')]/..")
	private WebElement EmployeeIconClick;
	
	@FindBy(xpath= "//a[@href='/ngapp/employee/main']")
	private WebElement EmployeeMain;
	
	@FindBy(xpath = "(//a[@href='/ngapp/employee/main/emp-directory'])")
	private WebElement EmpDirectory;
	
	@FindBy (xpath = "//button[text()='Add Employee']")
	private WebElement AddEmployeeButton;
	
	@FindBy(xpath = "(//a[@class='select2-choice'])[1]")
	private WebElement EmpNumSeriesDropodwn;
	
	@FindBy(xpath = "//div[@class='select2-result-label'][text()='Manual Entry']")
	private WebElement manualEntry;
	
	@FindBy(xpath = "//input[@name='employeeNo']")
	private WebElement EmpNumber;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement EmpName;
	
	@FindBy(xpath ="(//input[@type='radio'])[1]")
	private WebElement EmpGender;
	

	@FindBy(xpath ="(//a[@href='javascript:void(0)'])[2]")
	private WebElement EmpReportingManager;
	
	@FindBy(xpath ="//input[@name='doj']")
	private WebElement EmpDateOfJoining;
	
	@FindBy(xpath ="//input[@name='onboardingStatus']")
	private WebElement OnBoardingCheckBox;
	
	@FindBy(xpath ="//input[@type='email']")
	private WebElement EnterEmail;
	
	@FindBy(xpath ="(//button[@class='btn'])[2]")
	private WebElement clickOnNextButton;
	
	@FindBy(xpath ="(//div[@class='select2-container input-xlarge ng-pristine ng-valid'])[4]")
	private WebElement selectlocation;
	
	@FindBy(xpath = "//div[@class='select2-result-label'][text()='Bangalore']")
	private WebElement locationBangalore;
	
	@FindBy(xpath = "//button[@class='btn'][2]")
	private WebElement ClickonNextbutton;
	
	@FindBy (xpath ="//i[@class='icon-ok']")
	private WebElement clickonFinish;
	
	@FindBy(xpath = "//div[@class='inmplayer-popover-close-button']")
	private WebElement Popup;
	
	@FindBy(xpath="//p[contains(text(),'New Employee added successfully!')]")
	private WebElement EmpSuccessTextmessage;
	
	@FindBy(xpath="//a[contains(text(),' Sign Out ')]")
	private WebElement signout;
	
	@FindBy(xpath ="(//td[@class='data ng-binding'])[1]")
	private WebElement EmployeeNumber;
	
	
	@FindBy(xpath="(//div[@class='span12'])[2]")
	private WebElement ClickOutside;
	
	public void AddEmployeeAlertPopup() {
		Alertpopup.click();
	}
	
	public void EmployeeIconClick() {
		waitForElement(EmployeeIconClick);
		EmployeeIconClick.click();
	}
	
	public void EmployeeMainClick() {
		waitForElement(EmployeeMain);
		EmployeeMain.click();
	}
	
	public void clickOnEmpDirectory() {
		waitForElement(EmpDirectory);
		EmpDirectory	.click();
	}
	
	public void clickOnAddEmployee() {
		waitForElement(AddEmployeeButton);
		AddEmployeeButton.click();
	}
	
	public void selectEmpNumSeriesDropdown() throws InterruptedException {
		Thread.sleep(3000);
		EmpNumSeriesDropodwn.click();	
	}
	
	public void selectManualEntry() throws InterruptedException {
		Thread.sleep(2000);
		manualEntry.click();
		Thread.sleep(2000);
	}
	
	public void enterEmployeeNumber(int empNumber) {
		EmpNumber.sendKeys(String.valueOf(empNumber));
	}
	
	public void enterEmployeeName(String employeeName) {
		EmpName.sendKeys(employeeName);
	}
	
	public void selectgender() {
		EmpGender.click();
	}
	
	public void enterDOJ(String empJoinDate) {
		EmpDateOfJoining.sendKeys(empJoinDate);
	}
	
	public void clickOutsideToMakeCheckboxEnabled() {
		ClickOutside.click();
	}
	
	public void selectOnboardingcheckbox() throws InterruptedException {
			OnBoardingCheckBox.click();
		}
		
	
	
	public void enterEmailID(String EmailID) {
		EnterEmail.sendKeys(EmailID);
	}
	
	public void clickNextbutton() {
		clickOnNextButton.click();
	}
	
	
	public void selectLocation() throws InterruptedException {
		waitForElement(selectlocation);
		Thread.sleep(3000);
		selectlocation.click();
		Thread.sleep(2000);
		locationBangalore.click();
		Thread.sleep(2000);
	}
	
	public void clickNextbutton2() {
		ClickonNextbutton.click();
	}
	
	public void clickonNextbutton3() {
		waitForElement(clickOnNextButton);
		clickOnNextButton.click();
	}
	
	public void clickOnFinishButton() throws InterruptedException {
		waitForElement(clickonFinish);
		clickonFinish.click();
		Thread.sleep(6000);
	}
	
	public void EmployeeAddSuccessMessage() {
		waitForElement(EmpSuccessTextmessage);
		if (EmpSuccessTextmessage.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public String getEmployeeNumber() {
		String EmployeeNo = EmployeeNumber.getText();
		return EmployeeNo;
	}
	
	public void clickonSignOutButton() {
		signout.click();
	}
	
	

}
