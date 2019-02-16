package datadriven;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class parameterisation {
	public WebDriver driver=null;
	@BeforeSuite
	public void login() throws IOException
	{
		Properties p=new Properties();
		FileInputStream f=new FileInputStream("C:\\Users\\lakshmi\\eclipse-workspace2\\Framework\\src\\datadriven\\pro.properties");
		p.load(f);
		p.getProperty("uname");
		System.out.println(p.getProperty("uname"));
	
		if(p.getProperty("browser").contains("google"))
{
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
}
		else if(p.getProperty("browser").contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\lakshmi\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\lakshmi\\Downloads\\MicrosoftWebDriver.exe");
			 driver=new EdgeDriver();
		}
		driver.get(p.getProperty("url"));
	}

}
