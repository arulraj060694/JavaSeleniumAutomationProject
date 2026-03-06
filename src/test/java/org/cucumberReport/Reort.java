package org.cucumberReport;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reort {

	public static void reportGen(String json) {
		
		File f= new File("target");
		
		Configuration conf = new Configuration(f, "Login Page");
		
		conf.addClassifications("platform", "Eclipse");
		
		conf.addClassifications("TestName", "Arul");
		
		List<String> list = new LinkedList<>();
		list.add(json);
		
		ReportBuilder reportBuilder = new ReportBuilder(list, conf);
		reportBuilder.generateReports();
	}
}
