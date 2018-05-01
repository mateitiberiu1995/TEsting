package com.memorynotfound.test;

import org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.test.automationSearch;
import com.qa.test.buyQuantity;


public class ChromeSeleniumTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

	@Test
    public void testTakeScreenShot() throws InterruptedException {
    	
    	
    	driver.get("http://automationpractice.com/index.php");
    	
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
		Assert.assertEquals(expected, input);
    	
    	
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
     
            driver.quit();
        }
}

