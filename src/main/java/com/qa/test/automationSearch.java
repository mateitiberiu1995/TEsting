package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class automationSearch {
	
WebDriver driver;
	
	

	@FindBy(name = "search_query")
	private WebElement searchBox;

	public void searchFor(WebDriver driver, String text) throws InterruptedException {
		this.driver = driver;
		searchBox.clear();
		searchBox.sendKeys(text);
		searchBox.submit();
		Thread.sleep(500);
	}


}