package com.training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class Selenium_Locators {
	
	public static WebDriver driver;
	public String birthDate = "11/11/2002";
	
	@BeforeTest
	public void setUp()
	{   
		
		System.setProperty("webdriver.chrome.driver","C:/D_Drive/Appium/Softwares/Driver/chromedriver_win32_v72/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","K:/LearnSelenium/Software/chromedriver.exe");
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
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("testemail1@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("facebookpwd@123");
		selectBirthDate(birthDate);
		Thread.sleep(10);
	
		}
	
	@Parameters ({"Bdate"})
	@Test
	public void selectBirthDate (@Optional String date)
	{
		String DD[] = birthDate.split("/");
		System.out.println(DD[0]);
		
		Select day = new Select(driver.findElement(By.id("day")));
		Select month = new Select(driver.findElement(By.id("month")));
		Select year = new Select(driver.findElement(By.id("year")));
		day.selectByValue(DD[0]);
		month.selectByValue(DD[1]);
		year.selectByValue(DD[2]);
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
