package org.testRunner;

import org.cucumberReport.GenerativeReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\user\\eclipse-workspace\\SampleProject\\src\\test\\resources\\Features\\Test.feature", 
		glue = "org.testSteps", 
		plugin = "json:target\\jsonreport.json",
		tags="@regression")
public class TestRunner {

	@AfterClass
	public static void  generateReport() {
		
		GenerativeReport.generateReport("target\\jsonreport.json");

	}

}
