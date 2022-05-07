package com.internetbank.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readconfig {
	 
	Properties prop;
		public readconfig()  {
			
			File fil = new File("./Configuration/"+"data.properties");
			FileInputStream fileinput = null;
			try {
				fileinput = new FileInputStream(fil);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			prop = new Properties();
			
			try {
				prop.load(fileinput);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	}
		
		public String gerUrl() {
			String url = prop.getProperty("url");
			return url;
			
		}
		public String setUserId() {
			String userid = prop.getProperty("userid");
			return userid;
			
		}
		public String setPassword() {
			String password = prop.getProperty("password");
			return password;
			
		}
		public String setchropath() {
			String chropath = prop.getProperty("chropath");
			return chropath;
			
		}
		public String setfirepath() {
			String firepath = prop.getProperty("firepath");
			return firepath;
			
		}

}
