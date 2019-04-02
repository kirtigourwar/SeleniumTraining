package com.training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class Selenium_Locators {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{   
		
		System.setProperty("webdriver.chrome.driver","C:/D_Drive/Appium/Softwares/Driver/chromedriver_win32_v72/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test (priority =1)
    public void facebook_Signup() throws Exception  {
		
		WebElement fName = driver.findElement(By.xpath("//input[@id='u_0_j']"));
		fName.clear();
		fName.click();
		fName.sendKeys("fName");
		hilightElement(driver,fName);
		driver.findElement(By.name("lastname")).sendKeys("lName");
		driver.findElement(By.cssSelector("input#u_0_o"));
		//Thread.sleep(100);
	
		}
	
	@Parameters ({"webDriver","webElement"})
	@Test (priority =2)
	public void hilightElement(@Optional WebDriver driver, @Optional WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '2px solid red'", element);
	}
	/*@AfterTest
	public void Closure()
	{
	 driver.quit();	
	}*/
}
