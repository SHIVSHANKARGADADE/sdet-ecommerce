package com.internetbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver ldriver;
	public LoginPageObjects(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement logbtn;
	
	@FindBy(xpath ="//a[text()='Log out']")
	WebElement logout;
	
	
	public void setUserName(String username) {
		
		userid.sendKeys(username);
	}
	
	public void setPassword(String pass) {
		
		password.sendKeys(pass);
		
	}
	
	public void clickLogIn() {
		
		logbtn.click();
	}
public void clickLogOut() {
	
	Actions action = new Actions(ldriver);
	action.moveToElement(logout);
	logout.click();
	}
}















