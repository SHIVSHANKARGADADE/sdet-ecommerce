package com.internetbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPageObjects {

	WebDriver ldriver;
	public AddCustomerPageObjects(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement newcustomer;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement customername;
	
	@FindBy(xpath = "//input[contains(@value,'m')]")
	WebElement gender;
	
	@FindBy(id = "dob")
	WebElement datebirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement number;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement sunbtn;
	
	
	public void clickNewCustomer() {
		
		newcustomer.click();
	}
	
	public void setName(String name) {
		
		customername.sendKeys(name);
	}
	
	public void setGender() {
		
		gender.click();
	}
	
	public void setdateBirth(String day, String month, String year) {
		datebirth.sendKeys(day);
		datebirth.sendKeys(month);
		datebirth.sendKeys(year);
	}
	
	public void setAddress(String add) {
		
		address.sendKeys(add);
	}
	
	public void setCity(String ccity) {
		city.sendKeys(ccity);
		
	}
	
	public void setState(String sstate) {
		state.sendKeys(sstate);
		
	}
	public void setPin(String ppin) {
		pin.sendKeys(ppin);
		
	}
	
	public void setMobNo(String num) {
		number.sendKeys(num);
		
	}
	
	public void setEmail(String eemail) {
		
		email.sendKeys(eemail);
	}
	
	public void setPassword(String num) {
		
		password.sendKeys(num);
	}
	
	public void submitBtn() {
		sunbtn.click();
		
	}
}









