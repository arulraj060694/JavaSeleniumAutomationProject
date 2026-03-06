package org.facebooktestrunner;

import org.cucumberReport.Reort;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/LoginPage.feature", 
				glue = "org.stepfacebook",
				plugin = "json:target\\jsonreport.json")
public class TestRunner {

	
	
	@AfterMethod
	public void generate() {
		Reort.reportGen("target\\jsonreport.json");
	}
}
