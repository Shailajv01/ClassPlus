package com.classplus.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplus.pages.ClassplusLoginPage;


public class ClassplusLoginTest extends ClassplusBaseTest {

	//private static final Logger logger = Logger.getLogger(ClassplusLoginTest.class.getName());
	
	private static final Logger logger = Logger.getLogger(ClassplusBaseTest.class.getName());
	private WebDriver facultyDriver;
	private WebDriver studentDriver;

	@BeforeClass
	@Parameters({ "driveURL", "browser", "orgCode", "mobileNumber", "otp", "facultyMobileNumber",
			"studentMobileNumber" })
	public void initLogin(String driveURL, String browser, String orgCode, String mobileNumber, String otp,
			String studentMobileNumber, String facultyMobileNumber) throws Exception {

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		// this.driver = this.getWebDriver(browser, WEB_DRIVER.STOREHOME_DRIVER_TEST);
		this.facultyDriver = this.getWebDriver(browser, WEB_DRIVER.STOREHOME_FACULTYDRIVER_TEST);
		this.studentDriver = this.getWebDriver(browser, WEB_DRIVER.STOREHOME_STUDENTDRIVER_TEST);

		this.goToSite(this.driver, driveURL);
		this.goToSite(facultyDriver, driveURL);
		this.goToSite(studentDriver, driveURL);

		this.classplusloginpage = new ClassplusLoginPage(this.driver);
		this.facultyloginpage = new ClassplusLoginPage(this.facultyDriver);
		this.studentloginpage = new ClassplusLoginPage(this.studentDriver);

		super.loginToApplication(classplusloginpage, this.driver, orgCode, mobileNumber, otp);
		super.loginToApplication(facultyloginpage, this.facultyDriver, orgCode, facultyMobileNumber, otp);
		super.loginToApplication(studentloginpage, this.studentDriver, orgCode, studentMobileNumber, otp);

	}

	@Test(priority = 1)
	public void checkStoreHeaders() throws InterruptedException {

		this.classplusloginpage.clickOnStoreBtn();

		String searchForAcourse = this.classplusloginpage.getSerachForAcourse();
		Assert.assertEquals(searchForAcourse, expectedAssertionsProp.getProperty("SearchForAcourse.text"));

		String storeheaders = this.classplusloginpage.getSerachForAcourse();
		Assert.assertEquals(storeheaders, expectedAssertionsProp.getProperty("store.text"));

	}
	
	@AfterClass
	public void quitDriver() {
			this.quitDriver(this.driver, WEB_DRIVER.LOGIN_DRIVER);
			this.quitDriver(this.studentDriver, WEB_DRIVER.STOREHOME_FACULTYDRIVER_TEST);
			this.quitDriver(this.studentDriver, WEB_DRIVER.STOREHOME_STUDENTDRIVER_TEST);
			

		}
	

	/*
	 * Assert.assertEquals(this.classplusloginpage.getListOfStoreHeaders(),
	 * (expectedAssertionsProp.getProperty("store.headers")));
	 */

	/*
	 * @Test(priority = 1) public void loginToApplication() throws
	 * InterruptedException {
	 * 
	 * String logInToAppliacation = this.classplusloginpage.getLogintoAccount();
	 * Assert.assertEquals(logInToAppliacation,
	 * expectedAssertionsProp.getProperty("login.text"));
	 * 
	 * this.classplusloginpage.setOrgCode(testDataProp.getProperty("orgcode.text"));
	 * this.classplusloginpage.setMobileNumber(testDataProp.getProperty(
	 * "mobilenumber.text")); this.classplusloginpage.clickOnProceedSecurelyBtn();
	 * this.classplusloginpage.setOtp(testDataProp.getProperty("otp.text"));
	 * this.classplusloginpage.clickOnVerifyOtp();
	 * this.classplusloginpage.clickOnSoreBtn();
	 * 
	 * Assert.assertEquals(this.classplusloginpage.getListOfStoreHeaders(),
	 * (expectedAssertionsProp.getProperty("store.headers")),
	 * "ASSERTION FAILED:: Store Headers not matched");
	 * 
	 * }
	 * 
	 * @Test(priority = 2) public void loginToApplication1() throws
	 * InterruptedException {
	 * 
	 * this.facultyloginpage.setOrgCode(testDataProp.getProperty("orgcode.text"));
	 * this.facultyloginpage.setMobileNumber(testDataProp.getProperty(
	 * "faculty.mobilenumber.text"));
	 * this.facultyloginpage.clickOnProceedSecurelyBtn();
	 * this.facultyloginpage.setOtp(testDataProp.getProperty("otp.text"));
	 * this.facultyloginpage.clickOnVerifyOtp();
	 * this.facultyloginpage.clickOnSoreBtn();
	 * 
	 * }
	 * 
	 * @Test(priority = 3) public void loginToApplication2() throws
	 * InterruptedException {
	 * 
	 * this.Studentloginpage.setOrgCode(testDataProp.getProperty("orgcode.text"));
	 * this.Studentloginpage.setMobileNumber(testDataProp.getProperty(
	 * "student.mobilenumber.text"));
	 * this.Studentloginpage.clickOnProceedSecurelyBtn();
	 * this.Studentloginpage.setOtp(testDataProp.getProperty("otp.text"));
	 * this.Studentloginpage.clickOnVerifyOtp();
	 * this.Studentloginpage.clickOnSoreBtn();
	 * 
	 * }
	 */

}
