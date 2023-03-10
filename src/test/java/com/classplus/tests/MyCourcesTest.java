package com.classplus.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplus.pages.ClassplusLoginPage;
import com.classplus.pages.MyCourcesPage;
import com.classplus.tests.ClassplusBaseTest.WEB_DRIVER;

public class MyCourcesTest extends ClassplusBaseTest {

	private static final Logger logger = Logger.getLogger(ClassplusBaseTest.class.getName());
	private WebDriver facultyDriver;
	private WebDriver studentDriver;
	private ClassplusLoginPage classplusloginpage = null;

	@Test
	@Parameters({ "driveURL", "browser", "orgCode", "mobileNumber", "otp", "facultyMobileNumber",
			"studentMobileNumber" })
	public void initLogin(String driveURL, String browser, String orgCode, String mobileNumber, String otp,
			String studentMobileNumber, String facultyMobileNumber) throws Exception {

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		this.facultyDriver = this.getWebDriver(browser, WEB_DRIVER.STOREHOME_FACULTYDRIVER_TEST);
		this.studentDriver = this.getWebDriver(browser, WEB_DRIVER.STOREHOME_STUDENTDRIVER_TEST);

		/*
		 * this.driver = this.getWebDriver(browser,
		 * WEB_DRIVER.COURSECREATION_DRIVER_TEST); this.studentDriver =
		 * this.getWebDriver(browser,WEB_DRIVER.STUDENT_COURSECREATION_DRIVER_TEST);
		 */
		this.goToSite(this.driver, driveURL);
		this.goToSite(facultyDriver, driveURL);
		this.goToSite(studentDriver, driveURL);

		this.classplusloginpage = new ClassplusLoginPage(this.driver);
		this.facultyloginpage = new ClassplusLoginPage(this.facultyDriver);
		this.studentloginpage = new ClassplusLoginPage(this.studentDriver);
		this.mycourcespage = new MyCourcesPage(this.driver);

		super.loginToApplication(classplusloginpage, this.driver, orgCode, mobileNumber, otp);
		/*
		 * super.loginToApplication(facultyloginpage, this.facultyDriver, orgCode,
		 * facultyMobileNumber, otp); super.loginToApplication(studentloginpage,
		 * this.studentDriver, orgCode, studentMobileNumber, otp);
		 */
	}

	@Test(priority = 1)
	public void createCoures() throws InterruptedException {

		this.classplusloginpage.clickOnStoreBtn();
		this.mycourcespage.clickOnCreateCourseBtn();
		this.mycourcespage.setCourseName(testDataProp.getProperty("courseName.text"));
		this.mycourcespage.setDescription(testDataProp.getProperty("description.text"));
		this.mycourcespage.ClickOnselectDropdownValueFromCategories();
		this.mycourcespage.ClickOnselectDropdownValueFromSubCategories();
		this.mycourcespage.setPrice(testDataProp.getProperty("price.text"));
		this.mycourcespage.setDiscount(testDataProp.getProperty("discount.text"));

		this.mycourcespage.clickOnChargesChkbox();
		this.mycourcespage.clickOnAgreeTermsAndConditionsChkbox();

		/*
		 * String createCourse = this.mycourcespage.getTitle();
		 * Assert.assertEquals(createCourse,
		 * expectedAssertionsProp.getProperty("createCourse.text"));
		 */
	}

}
