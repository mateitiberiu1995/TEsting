package com.memorynotfound.test;

import org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.test.automationSearch;
import com.qa.test.buyQuantity;
import com.qa.utility.HelperMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ChromeSeleniumTest {

    private static WebDriver driver;
    public static ExtentReports report;
	public static ExtentTest test;

    @BeforeClass
    public static void setUp(){
    	report = new ExtentReports("C:\\Users\\Admin\\Desktop\\BasicReport.html", true);

		test = report.startTest("Verify the price");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
	@Test
    public void testTakeScreenShot() throws InterruptedException {
    	
    	
    	driver.get("http://demoqa.com/registration/"); //*[@id="name_3_firstname"]
    	driver.findElement(By.xpath("//*[@id=\"name_3_firstname\"]")).sendKeys("Tiberiu");
    	Thread.sleep(1000);
    	test.log(LogStatus.INFO, "Added firstName");
    	driver.findElement(By.xpath("//*[@id=\"name_3_lastname\"]")).sendKeys("Matei");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Added LastName");
    	WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input[1]"));
    	checkElement.click();
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "clicked pie single");
    	driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input[2]")).click();
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "clicked hobby reader");
    	checkElement=driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]"));
    	checkElement.click();

    	checkElement=driver.findElement(By.xpath("//*[@id=\"dropdown_7\"]/option[149]"));
    	checkElement.click(); //*[@id="mm_date_8"]
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Selected Romania");
    	driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"mm_date_8\"]/option[6]")).click();
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Selected 5th month");
    	driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"dd_date_8\"]/option[27]")).click();
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Selected 26th day");
    	driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"yy_date_8\"]/option[21]")).click(); 
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Selected 1995");
    	checkElement=driver.findElement(By.xpath("//*[@id=\"phone_9\"]"));
    	checkElement.sendKeys("07379291267");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "wrote my phone number");
    	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("gummy199d4");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "wrote my username");
    	driver.findElement(By.xpath("//*[@id=\"email_1\"]")).sendKeys("something3dd2145@gmail.com");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "wrote my email");
    	checkElement = driver.findElement(By.xpath("//*[@id=\"profile_pic_10\"]"));
    	checkElement.sendKeys("C:\\Users\\Admin\\Desktop\\download.jpg");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "uploaded a profile picture");
    	driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("short description");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Added a short description");
    	driver.findElement(By.xpath("//*[@id=\"password_2\"]")).sendKeys("ceimiplacemie12");
    	driver.findElement(By.xpath("//*[@id=\"confirm_password_password_2\"]")).sendKeys("ceimiplacemie12");
    	Thread.sleep(1000); 
    	test.log(LogStatus.INFO, "Added my password and confirmed password");
    	driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input")).click();
    	Thread.sleep(7000);
    	String expected = "Thank you for your registration";
    	String input = driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).getText();
    	if(expected.equals(input)) {
			test.log(LogStatus.PASS, "The account was added");
		}
		else
		{
			test.log(LogStatus.FAIL, "The account wasnt added");
		}
    	
    	//Assert.assertEquals(expected, driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).getText() );
    	//*[@id="post-49"]/div/p  Thank you for your registration
    	/*test.log(LogStatus.INFO, "Browser started");
    	
		automationSearch page = PageFactory.initElements(driver, automationSearch.class);
		page.searchFor(driver, "shirt");

		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
		checkElement.click();
		buyQuantity page2 = PageFactory.initElements(driver, buyQuantity.class);
		page2.buy(driver, 5);
		page.searchFor(driver, "dress");
		checkElement =driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));
		checkElement.click();
		

		page2.buy(driver, 2);
		Thread.sleep(2000);
		checkElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
		checkElement.click();
		checkElement = driver.findElement(By.xpath("//*[@id=\"total_price\"]"));
		String input = checkElement.getText();
		String expected = "$186.53";
		HelperMethods.screenshot(driver);

		if(expected.equals(input)) {
			test.log(LogStatus.PASS, "Verify the price");
		}
		else
		{
			test.log(LogStatus.FAIL, "Verify the price");
		}
    	
    	
       /* driver.get("http://thedemosite.co.uk/");
        WebElement checkElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
        checkElement.click();
        checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
        checkElement.sendKeys("gummy1994");
        Thread.sleep(2000);
        checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
        checkElement.sendKeys("ceimiplacemie12");
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        Thread.sleep(2000);*/

        
        
    }

    @AfterClass
    public static void cleanUp(){
    		report.endTest(test);
    		report.flush();
            driver.quit();
        }
}

