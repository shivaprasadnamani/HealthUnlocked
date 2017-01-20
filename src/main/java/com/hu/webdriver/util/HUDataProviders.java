package com.hu.webdriver.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

/**
 *
 * @author Venkatesh.Aarelly
 *
 */
public class HUDataProviders {

	private final CSVDataReader csvDataReader = new CSVDataReader();
	private final ExcelDataReader excelDataReader = new ExcelDataReader();

	@DataProvider(name="csvdata")
	public Object[][] getCsvData(){
		Object[][] data = null;
		try {
			data = csvDataReader.getCSVDataArray("src\\main\\resources\\data\\InvalidUsersCSV.csv", null, true);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@DataProvider(name="exceldata")
	public Object[][] getExcelData(){
		Object[][] data = null;
		try {
			data = excelDataReader.getExcelDataArray("src\\main\\resources\\data\\InvalidUsersExcel.xlsx", null, true, true);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
