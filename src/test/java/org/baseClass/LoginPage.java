package org.baseClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginPage extends BaseClass {

	@Parameters({"browser"})
	@Test

	public void ToLaunchBrowser(String browserType) throws IOException {
	
			getBrowser(browserType);

	}
	@Test
	public void ToLaunchApplication() throws IOException {

			launchURL(getDataFromExcelSheet("Sheet1", 2, 0));
		
	}
	
	@Test 
	 
	public void loginCredentials() throws IOException {
		
		WebElement element = driver.findElement(By.name("username"));
		
		sendKeysByJSE(getDataFromExcelSheet("Sheet1", 1, 0), element);
		
		WebElement element2 = driver.findElement(By.id("password"));
		
		sendKeysByJSE(getDataFromExcelSheet("Sheet1", 3, 0), element2);
		
		WebElement element3 = driver.findElement(By.id("submit"));
		
		clickByActions(element3);
		
		driver.quit();
		
		

	}
	

}
