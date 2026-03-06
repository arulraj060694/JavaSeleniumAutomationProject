package org.baseClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTesting extends BaseClass {

	@DataProvider(name="inputDatas")
	public Object[][] dataProviderMethod() throws IOException {
		

		
		return new Object[][] {
			{getDataFromExcelSheet("Sheet1", 4, 0), getDataFromExcelSheet("Sheet1", 4, 1)},
			{getDataFromExcelSheet("Sheet1", 5, 0), getDataFromExcelSheet("Sheet1", 5, 1)},
			{getDataFromExcelSheet("Sheet1", 6, 0), getDataFromExcelSheet("Sheet1", 6, 1)},

		};
	}
	
	
	@Test(dataProvider="inputDatas")

	public void test01(String t ,String r) {
		System.out.println(t + "=" + r);

	}
	
}	