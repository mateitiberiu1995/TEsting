package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperMethods {

	public static void screenshot(WebDriver driver) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = "C:\\Users\\Admin\\Desktop\\selenium\\target"
				+ "Pass" + dateName + ".png";

		File finalDestination = new File(destination);

		try {
			FileHandler.copy(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}