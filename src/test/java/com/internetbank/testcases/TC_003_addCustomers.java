package com.internetbank.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.internetbank.pageobjects.AddCustomerPageObjects;
import com.internetbank.pageobjects.LoginPageObjects;



public class TC_003_addCustomers extends BaseClass{

	@Test
	public void addNewCustomer() {
		
		LoginPageObjects loginpage = new LoginPageObjects(driver);
		loginpage.setUserName(userid);
		logger.info("userid is entered");
		loginpage.setPassword(password);
		logger.info("password is entered");
		loginpage.clickLogIn();
		logger.info("click on login");
		AddCustomerPageObjects customers = new AddCustomerPageObjects(driver);
		customers.clickNewCustomer();
		
		logger.info("providing customer detail");
		customers.setName("Shivshankar gadade");
		customers.setGender();
		customers.setdateBirth("01", "09", "1995");
		customers.setAddress("Bhagat singh chawk beed");
		customers.setCity("Beed");
		customers.setState("Maharashtra");
		customers.setPin("431517");
		customers.setMobNo("9975156805");
		customers.setEmail("gadade8@gmail.com");
		customers.setPassword("99751568");
		customers.submitBtn();
	
		boolean flag = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(flag == true) {
			Assert.assertTrue(true);
			logger.info("test is passed");
		}else {
			
			Assert.assertTrue(false);
			logger.info("test is failed");
		}
		
		
	}
	
}











