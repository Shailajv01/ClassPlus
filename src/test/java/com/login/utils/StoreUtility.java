package com.login.utils;

import com.classplus.pages.CreateCourseWithDataProvider;
import com.classplus.tests.ClassplusBaseTest;

public class StoreUtility extends ClassplusBaseTest{
	
	public void createValidityCourse(CreateCourseWithDataProvider createCourseWithDataProvider, String courseName,
			String price, String discount, String category, String subcategory, String Coursename) {
		createCourseWithDataProvider.clickOnCreateCourseBtn();
		createCourseWithDataProvider.setCourseName(Coursename);
		createCourseWithDataProvider.setDescription(testDataProp.getProperty("description.text"));
		createCourseWithDataProvider.ClickOnselectDropdownValueFromCategories();
		createCourseWithDataProvider.ClickOnselectDropdownValueFromSubCategories();
		createCourseWithDataProvider.setPrice(testDataProp.getProperty("price.text"));
		createCourseWithDataProvider.setDiscount(testDataProp.getProperty("discount.text"));	
		createCourseWithDataProvider.clickOnChargesChkbox();
		createCourseWithDataProvider.clickOnAgreeTermsAndConditionsChkbox();
		
	}

	public void createCourse1(CreateCourseWithDataProvider createCourseWithDataProvider, String courseName) {

		createCourseWithDataProvider.clickOnCreateCourseBtn();
		createCourseWithDataProvider.setCourseName(courseName);
		createCourseWithDataProvider.setDescription(testDataProp.getProperty("description.text"));
		createCourseWithDataProvider.ClickOnselectDropdownValueFromCategories();
		createCourseWithDataProvider.ClickOnselectDropdownValueFromSubCategories();
		createCourseWithDataProvider.setPrice(testDataProp.getProperty("price.text"));
		createCourseWithDataProvider.setDiscount(testDataProp.getProperty("discount.text"));	
		createCourseWithDataProvider.clickOnChargesChkbox();
		createCourseWithDataProvider.clickOnAgreeTermsAndConditionsChkbox();
	}

	public void createCourse(CreateCourseWithDataProvider createCourseWithDataProvider, String courseName) {
		// TODO Auto-generated method stub
		
	}

}
