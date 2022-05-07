package com.internetbank.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.internetbank.testcases.BaseClass;

public class Listener extends BaseClass implements ITestListener{

	
	public ExtentReports extent ;
	public ExtentSparkReporter spark ;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {

		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		extent = new ExtentReports();
		File fil = new File("./test-output/"+timestamp+"extentReport.html");
		spark = new ExtentSparkReporter(fil);
		extent.attachReporter(spark);

		try {
			spark.loadXMLConfig("./Configuration/"+"extent-config.xml");
		} catch (IOException e) {

			e.printStackTrace();
		}

		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Shiva");

		spark.config().setReportName("e-banking");
		spark.config().setDocumentTitle("Test automation report");


	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		
		test = extent.createTest(tr.getName())
				.log(Status.PASS, "Test is passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName())
				.log(Status.FAIL, "Test is failed");
		System.out.println(tr.getName()+ "_" +tr.getMethod().getMethodName());
		
		String base64 = captureScreenShots();
		
		test.addScreenCaptureFromBase64String(base64);
		try {
			takesScreenShots(tr.getName());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName())
				.log(Status.SKIP, "Test is skipped");
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult tr) {

	}


	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();

	}

	

}


















