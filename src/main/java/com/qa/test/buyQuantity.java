package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class buyQuantity {
	
	WebDriver driver;
	
	

	@FindBy(id = "quantity_wanted")
	private WebElement searchBox;

	public void buy(WebDriver driver, int quantity) throws InterruptedException {
		this.driver = driver;
		searchBox.clear();
		searchBox.sendKeys(String.valueOf(quantity));
		searchBox.findElement(By.xpath("//*[@id=\"group_1\"]"));
		searchBox.click();
		searchBox.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();
		searchBox.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		Thread.sleep(1000);
		searchBox.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
	}

}