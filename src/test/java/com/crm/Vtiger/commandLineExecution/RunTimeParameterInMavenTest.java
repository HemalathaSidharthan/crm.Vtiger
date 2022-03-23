package com.crm.Vtiger.commandLineExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTimeParameterInMavenTest {
	WebDriver driver;
	
	String browsername;
	String url;
	String username;
	String password;
	
	@Test
	public void login()
	{
		System.out.println("Browser launch");
		browsername=System.getProperty("browsername");
		url=System.getProperty("url");
		username=System.getProperty("username");
		password=System.getProperty("password");

			
			if(browsername.equals("chrome")) 
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();}
			else if(browsername.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("Invalid browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			
			//login

			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			//logout
			System.out.println("--------Logout -------------");
			WebElement user=driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
			Actions act=new Actions(driver);
			act.moveToElement(user).perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();

			
	}

}
