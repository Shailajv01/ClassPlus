package com.classplus.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ClassplusLoginPage extends ClassplusBasePage  {
	
	private static final Logger logger = Logger.getLogger(ClassplusLoginPage.class.getName());
	
	@FindBy(xpath ="//p[text()='Login to your account]")
	private WebElement txtLogintoAccount ;
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement txtOrgCode ;
	
	@FindBy(xpath ="//input[@type='number']")
	private WebElement txtMobileNumber ;
	
	@FindBy(xpath ="//button[@role='button']")
	private WebElement btnProceedSecurely ;
	
	@FindBy(xpath ="//input[@id='otp_input']")
	private WebElement txtOtp ;
	
	@FindBy(xpath ="//button[@class='ui primary button']")
	private WebElement verifyOtp ;
	
	@FindBy(xpath ="//p[text()='Store']")
	private WebElement btnStore ;
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement txtSerachForAcourse ;
	
	
	@FindBy(xpath ="//div[contains(@class,'Header_Container')]//div//div")
	private List<WebElement> storeHeaders ;
	
	
	public ClassplusLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
			
	}
	
	public String getLogintoAccount() {
		return txtLogintoAccount.getText();
			
	}
	
	public void setOrgCode(String OrgCode) {
		this.txtOrgCode.sendKeys(OrgCode);
		
	}
	
	public void setMobileNumber(String MobileNumber) {
		this.txtMobileNumber.sendKeys(MobileNumber);
		
	}

	public void clickOnProceedSecurelyBtn(){
		this.btnProceedSecurely.click();
		
	}
	
	public void loginToClassplusUsingMobileNumber(String strOrgCode, String strMobileNumber, String strEmailAddress) {
		
		try {
			this.setOrgCode(strOrgCode);
			this.setMobileNumber(strMobileNumber);
		} catch (Exception e) {

			try {
				this.setMobileNumber(strMobileNumber);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (isEnabledProceedSecurelyButton() == true) {
			this.clickOnProceedSecurelyBtn();
		} else {
			//this.hardWait(5);
			this.clickOnProceedSecurelyBtn();

		}

		//log.info("Ending loginToClassplusUsingMobileNumber method");
	}

	private boolean isEnabledProceedSecurelyButton() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setOtp(String Otp) {
		this.txtOtp.sendKeys(Otp);
		
	}
	
	public void clickOnVerifyOtp() {
		this.verifyOtp.click();
	}
	
	public void clickOnStoreBtn() {
		hardWait(1);
		this.btnStore.click();
	}
	
	
	
	public List<String> getListOfStoreHeaders() {
		List<String> store = new ArrayList<String>();

		for (WebElement element : storeHeaders) {
			System.out.println(element);
			store.add(element.getText());
			System.out.println(store);
		}
		return store;
	}
	
	public String getSerachForAcourse() {
		return txtSerachForAcourse.getText();
			
	}
}
