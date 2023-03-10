package com.classplus.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplus.pages.ClassplusLoginPage;
import com.classplus.pages.CreateCourseWithDataProvider;
import com.classplus.pages.MyCourcesPage;
import com.classplus.tests.ClassplusBaseTest.WEB_DRIVER;
import com.login.utils.StoreUtility;

public class CreateClassDataProvideTest extends StoreUtility {

	private static final Logger logger = Logger.getLogger(CreateClassDataProvideTest.class.getName());
	private static final String STOREHOME_DRIVER_TEST = null;
	private static final String STOREHOME_FACULTYDRIVER_TEST = null;
	private static final String STOREHOME_STUDENTDRIVER_TEST = null;
	private WebDriver facultyDriver;
	private WebDriver studentDriver;
	private ClassplusLoginPage classplusloginpage = null;

	@BeforeClass
	@Parameters({ "driveURL", "browser", "orgCode", "mobileNumber", "otp", "facultyMobileNumber",
			"studentMobileNumber" })
	public void initLogin(String driveURL, String browser, String orgCode, String mobileNumber, String otp,
			String studentMobileNumber, String facultyMobileNumber) throws Exception {

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		/*
		 * this.facultyDriver = this.getWebDriver(browser,
		 * WEB_DRIVER.STOREHOME_FACULTYDRIVER_TEST); this.studentDriver =
		 * this.getWebDriver(browser, WEB_DRIVER.STOREHOME_STUDENTDRIVER_TEST);
		 */
		/*
		 * this.driver = this.getWebDriver(browser,
		 * WEB_DRIVER.COURSECREATION_DRIVER_TEST); this.studentDriver =
		 * this.getWebDriver(browser,WEB_DRIVER.STUDENT_COURSECREATION_DRIVER_TEST);
		 */
		this.goToSite(this.driver, driveURL);
		/*
		 * this.goToSite(facultyDriver, driveURL); this.goToSite(studentDriver,
		 * driveURL);
		 */

		this.classplusloginpage = new ClassplusLoginPage(this.driver);
		this.facultyloginpage = new ClassplusLoginPage(this.facultyDriver);
		this.studentloginpage = new ClassplusLoginPage(this.studentDriver);
		// this.mycourcespage = new MyCourcesPage(this.driver);
		this.createCourseWithDataProvider = new CreateCourseWithDataProvider(this.driver);

		super.loginToApplication(classplusloginpage, this.driver, orgCode, mobileNumber, otp);
	}

	public void verifyCourseCreated(String courseName) {
		super.createCourse(createCourseWithDataProvider, courseName);
	}

	@Test(priority = 1)
	public void testCourseCreationPageVisible() {
		try {
			this.classplusloginpage.clickOnStoreBtn();
			this.createCourseWithDataProvider.clickOnCreateCourseBtn();
			Assert.assertEquals(createCourseWithDataProvider.getTitle(),
					expectedAssertionsProp.getProperty("create.course.heading"),
					"ASSERTION FAILED:: Course Creation Page Heading not matched as expected");
		}

		catch (Exception e) {
			Assert.fail("Exception occured while testing page heading: " + e.getMessage());
			logger.error("Error occured while testing page heading", e);
		}
	}

	@Test(priority = 2, dataProvider = "login", description="valid")
	public void createCourse(String Scenario, String Coursename) throws InterruptedException {

		   // this.createCourseWithDataProvider.clickOnCreateCourseBtn();
			this.createCourseWithDataProvider.setCourseName(Coursename);
			this.createCourseWithDataProvider.setDescription(testDataProp.getProperty("description.text"));
			this.createCourseWithDataProvider.ClickOnselectDropdownValueFromCategories();
			this.createCourseWithDataProvider.ClickOnselectDropdownValueFromSubCategories();
			this.createCourseWithDataProvider.setPrice(testDataProp.getProperty("price.text"));
			this.createCourseWithDataProvider.setDiscount(testDataProp.getProperty("discount.text"));
			this.createCourseWithDataProvider.clickOnChargesChkbox();
			this.createCourseWithDataProvider.clickOnAgreeTermsAndConditionsChkbox();
			this.createCourseWithDataProvider.clickOnAddContentBtn();
			
			if(Scenario.equals("valid")) {
				
				
				String couseCreated = this.createCourseWithDataProvider.getTitleCourseCreated();
				Assert.assertEquals(couseCreated, expectedAssertionsProp.getProperty("course.created.text"));
				System.out.println(expectedAssertionsProp.getProperty("course.created.text"));
				driver.navigate().back();

			}
			else if(Scenario.equals("invalid")) 
			{
				String couseNotCreated = this.createCourseWithDataProvider.getTitleErrorMsg();
				Assert.assertEquals(couseNotCreated, expectedAssertionsProp.getProperty("min.four.chars.text"));
			}
			else {
				System.out.println("Course Created");
			}
			
	
	}

	//@Test(priority = 3, dataProvider = "getData")
	public void createInavalidCourse(String Scenario, String Coursename) throws InterruptedException {
		
		
		this.createCourseWithDataProvider.setCourseName(Coursename);
		this.createCourseWithDataProvider.setDescription(testDataProp.getProperty("description.text"));
		this.createCourseWithDataProvider.ClickOnselectDropdownValueFromCategories();
		this.createCourseWithDataProvider.ClickOnselectDropdownValueFromSubCategories();
		this.createCourseWithDataProvider.setPrice(testDataProp.getProperty("price.text"));
		this.createCourseWithDataProvider.setDiscount(testDataProp.getProperty("discount.text"));
		this.createCourseWithDataProvider.clickOnChargesChkbox();
		this.createCourseWithDataProvider.clickOnAgreeTermsAndConditionsChkbox();

	}

	@DataProvider(name="login", parallel = true)
	public Object[][] getData() {

		return new Object[][] { 
			{ "valid", "Qwerty" }, 
			{ "invalid", "as" }

		};

	}
}
