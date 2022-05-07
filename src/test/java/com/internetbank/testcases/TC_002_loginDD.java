package com.internetbank.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbank.pageobjects.LoginPageObjects;
import com.internetbank.utility.XlsxUtility;

public class TC_002_loginDD extends BaseClass {

	@Test(dataProvider ="logindata" )
	public void logInDD(String user, String pass) {
		
		LoginPageObjects loginobj = new LoginPageObjects(driver);
		loginobj.setUserName(user);
		logger.info("user name is set");
		loginobj.setPassword(pass);
		logger.info("password is set");
		loginobj.clickLogIn();
		logger.info("click on log in button");
		
		if(isAlertPresent() == true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}else {
			
			Assert.assertTrue(true);
			logger.info("Login passed");
			loginobj.clickLogOut();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		

	}
		// userdefined method
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			
			return false;
			
		}
		
		
		
		
	}

	@DataProvider(name ="logindata")

	public Object[][] getData() throws IOException{

		String path = "./src\\test\\java\\com\\internetbank\\testdata\\Book1.xlsx";
		int rownum = XlsxUtility.getRowCount(path, "sheet1");
		int colnum = XlsxUtility.getCellCount(path, "sheet1", 1);
		Object[][] obj = new Object[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				obj[i-1][j]=XlsxUtility.getCellData(path,"Sheet1", i,j);
			}

		}
		return obj;
	}

}
















