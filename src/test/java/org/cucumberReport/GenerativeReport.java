package org.cucumberReport;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class GenerativeReport {
	public static void generateReport(String json) {

		// to locate the file generation location
		File file = new File("target");

		// to add the configuration

		Configuration configuration = new Configuration(file, "Practice Login Funtion");

		configuration.addClassifications("Platform", "Eclipse JDK 1.8");

		configuration.addClassifications("version", "2.1");
		
		configuration.addClassifications("BDD", "cucumber+Junit");

		// add the empty list
		
		List<String> list = new LinkedList<>();
		
		list.add(json);
		
		// to generate report
		
		ReportBuilder reportBuilder = new ReportBuilder(list, configuration);
		
		reportBuilder.generateReports();
		
	}

}
