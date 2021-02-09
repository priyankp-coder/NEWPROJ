/*
 * Author : Priyank Pathak
 * 
 * 
 * */

package com.youinfo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.yourinfo.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException{

		prop = new Properties(); {
			FileInputStream ip = new FileInputStream("C:\\Users\\Priyank"
					+ "\\eclipse-workspace\\yourinfo\\src\\main\\java\\com"
					+ "\\youinfo\\config\\config.properties");
			prop.load(ip);
		}
	}
	public static WebDriver initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\"
					+ "Software\\Driver\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();  
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\Naveen"
					+ "\\Software\\Driver\\Firefox\\Ver 28\\geckodriver.exe"); 
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
}
