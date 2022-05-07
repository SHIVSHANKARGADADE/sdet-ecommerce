package com.internetbank.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbank.pageobjects.LoginPageObjects;



public class TC_001_login extends BaseClass {

	

	@Test(priority = 1)
	public void logIn() {
		
		LoginPageObjects LoginPageObjects = new LoginPageObjects(driver);
		LoginPageObjects.setUserName(userid);
		logger.info("userid is entered");
		LoginPageObjects.setPassword(password);
		logger.info("password is entered");
		LoginPageObjects.clickLogIn();
		logger.info("click on login");
		Assert.assertTrue(true);


	}
	@Test(priority = 2)

	public void getTitle() {
		
		String actualTitle = driver.getTitle();
		logger.info("get the title");
		String ExcepTitle = " Guru99 Bank Manager HomePage ";
		
		Assert.assertEquals(ExcepTitle, actualTitle);
		logger.info("Title is matched");
	}

	@Test(priority = 3)

	public void logOut() {
		LoginPageObjects LoginPageObjects = new LoginPageObjects(driver);
		LoginPageObjects.clickLogOut();
		logger.info("click on log out");
		Alert alert = driver.switchTo().alert();
		logger.info("switch to alert");
		String axtualtext = alert.getText();
		logger.info("get the title");
		alert.accept();
		String expectedtext = "You Have Succesfully Logged Out!!";
		System.out.println(axtualtext);
		
		Assert.assertEquals(axtualtext, expectedtext);
		logger.info("Text is matched");
		
	}
	
}










