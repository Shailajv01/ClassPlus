package com.classplus.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCourseWithDataProvider extends ClassplusBasePage {

		
		@FindBy(xpath = "//div//div[@class='Header_createCourse__MIfFo']")
		private WebElement btnCreateCourse;

		@FindBy(xpath = "//h1[text()='Create Course']") // h1[contains(text(),'Create Course')
		private WebElement txtCreateCourse;

		@FindBy(xpath = "//h1[text()='Create Course']//following::input[1]")
		private WebElement txtEnterCourseName;

		@FindBy(xpath = "//textarea[@placeholder='Description goes here']")
		private WebElement txtDescription;

		@FindBy(xpath = "//div[text()='Pick your Categories']")
		private WebElement selectCategory;

		@FindBy(xpath = "//div[@class='menu transition visible']")
		private List<WebElement> selectCategoryOptions;

		@FindBy(xpath = "//span[text()='Photography']")
		private WebElement ddselectCategoryOptions;

		@FindBy(xpath = "//div[text()='Pick your Subcategories']")
		private WebElement selectSubCategory;

		@FindBy(xpath = "//div[@class='menu transition visible']")
		private List<WebElement> selectSubCategoryOptions;

		@FindBy(xpath = "//span[text()='sasa']")
		private WebElement ddselectSubCategoryOptions;

		@FindBy(xpath = "//input[@type='text']//following::input[@placeholder='Enter price, ₹']")
		private WebElement txtPrice;

		@FindBy(xpath = "//input[@placeholder='Discount in optional']")
		private WebElement txtDiscount;

		@FindBy(xpath = "//div[normalize-space()='Internet Handling Charges']//following::input[1]")
		private WebElement chkbox;

		@FindBy(xpath = "//input[@type='checkbox']//following::div[@class='ui fitted checkbox']")
		private WebElement chkboxAgree;
		
		@FindBy(xpath = "//button[text()='Add Content']")
		private WebElement btnAddContent;
		
		@FindBy(xpath = "//div[text()='Add Content']")
		private WebElement txtAddContent;
		
		@FindBy(xpath = "//div[text()='Course Created Successfully']")
		private WebElement txtCourseCreated;
		
		@FindBy(xpath ="//div[text()='Minimum 4 non space characters required for Course name']")
		private WebElement txtErrorMsg;
		
		public CreateCourseWithDataProvider(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

		public void clickOnCreateCourseBtn() {
			this.btnCreateCourse.click();
		}

		public String getTitle() {
			return txtCreateCourse.getText();

		}

		public void setCourseName(String CourseName) {
			this.txtEnterCourseName.sendKeys(CourseName);
			this.txtEnterCourseName.clear();
			
			/*
			 * txtEnterCourseName.sendKeys(Keys.CONTROL+"A");
			 * txtEnterCourseName.sendKeys(Keys.DELETE);
			 */

		}

		public void setDescription(String Description) {
			this.txtDescription.sendKeys(Description);
		}

		public void ClickOnselectDropdownValueFromCategories() {
			selectCategory.click();
			// pickFromWebElement(selectCategoryOptions, selectFromCategory );
			scrollDown(300);
			ddselectCategoryOptions.click();
		}

		public void ClickOnselectDropdownValueFromSubCategories() {
			selectSubCategory.click();
			// pickFromWebElement(selectSubCategoryOptions, selectFromSubCategory );
			scrollDown(300);
			ddselectSubCategoryOptions.click();
		}

		public void setPrice(String Price) {
			try {
				hardWait(3);
				this.txtPrice.clear();
				this.txtPrice.sendKeys(Price);
			} catch (Exception e) {
				clickOnWebElement(txtPrice);
			}

		}

		public void setDiscount(String Discount) {
			this.txtDiscount.sendKeys(Discount);
		}
		

		public void clickOnChargesChkbox() {
			try {

				this.chkbox.click();
			} catch (Exception e) {
				clickOnWebElement(chkbox);
			}

		}

		public void clickOnAgreeTermsAndConditionsChkbox() {
			this.chkboxAgree.click();

		}
		
		public void clickOnAddContentBtn() {
			this.btnAddContent.click();

		}
		
		public boolean addContentisDiaplayed() {
			return this.txtAddContent.isDisplayed();
		}


		public String getTitleCourseCreated() {
			return txtCourseCreated.getText();

		}
		
		public String getTitleErrorMsg() {
			return txtErrorMsg.getText();

		}
			
			

		}
		
	
	

