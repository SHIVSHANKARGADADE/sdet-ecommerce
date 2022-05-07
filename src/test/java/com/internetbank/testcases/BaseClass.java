package com.internetbank.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.internetbank.utility.readconfig;





public class BaseClass {

	readconfig read = new readconfig();

	public String userid = read.setUserId();
	public String password = read.setPassword();
	public String url = read.gerUrl();
	public static WebDriver driver;
	public static Logger logger;


	@BeforeClass
	@Parameters({"browser"})

	public void setUp(@Optional("chrome") String browser) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("./Configuration/"+"log4j2.properties");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",read.setchropath());
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",read.setfirepath());
			driver = new FirefoxDriver();
		}

		driver.get(url);
		logger.info("open url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterClass
	public void tearDown() {	
		driver.quit();

	}
	
	
	public static String captureScreenShots () {
		TakesScreenshot base = (TakesScreenshot)driver;
		String base64 = base.getScreenshotAs(OutputType.BASE64);
		return base64;
		
	}
	public static void takesScreenShots(String tnmae) throws Exception {

		TakesScreenshot ts = (TakesScreenshot)driver;
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);

		File target = new File("./Screenshots/"+timestamp+tnmae+".png");
		FileUtils.copyFile(source, target );
		
	}

	

	
}