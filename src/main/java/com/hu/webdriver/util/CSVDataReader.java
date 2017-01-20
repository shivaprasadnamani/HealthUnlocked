package com.hu.webdriver.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.collections.Lists;

/**
 *
 * @author Venkatesh.Aarelly
 *
 */
public class CSVDataReader  {

	private static String cvsSplitBy = ",";

	private static Object[][] toArray(List<List> testReport) {
		final Object[][] report = new Object[testReport.size()][];
		int i = 0;
		for(final List row : testReport) {
			int j = 0;
			report[i] = new Object[row.size()];
			for(final Object cell : row) {
				report[i][j] = cell;
				j++;
			}
			i++;
		}
		return report;
	}

	/**
	 * Method to read the csv file.
	 *
	 * @param filePath
	 *            (file path)
	 * @throws IOException
	 */
	public Object[][] getCSVDataArray(final String filePath, final String sheetName, boolean isSkipHeader) throws IOException {
		final List<List> testReport = readFile(filePath,isSkipHeader);
		return toArray(testReport);
	}

	/**
	 * Method to read the file.
	 *
	 * @param filePath
	 *            (file path)
	 * @throws IOException
	 */
	public List<List> readFile(final String filePath, boolean isSkipHeader) throws IOException {
		String line = "";
		BufferedReader br = null;
		final List<List> testReport = Lists.newArrayList();
		try {
			br = new BufferedReader(new FileReader(filePath));
			if(isSkipHeader){
				br.readLine();
			}
			while ((line = br.readLine()) != null) {
				final List<String> rowData = Lists.newArrayList();
				final String[] splitLineArray = line.split(cvsSplitBy);
				String append = "";
				boolean found = false;
				for (String splitVal : splitLineArray) {
					if (splitVal.startsWith("\"") || found) {
						String currentSplit = splitVal;
						if(!found) {
							currentSplit = currentSplit.substring(1);
						}
						append = append + currentSplit;
						found = true;
					}
					if (splitVal.endsWith("\"")) {
						splitVal = append.substring(0, append.length() - 1);
						append = "";
						found = false;
					} else if (StringUtils.isNotEmpty(append)) {
						append += cvsSplitBy;
					}
					if (!found) {
						rowData.add(splitVal);
					}
				}
				testReport.add(rowData);
			}
		} finally {
			if(br != null) {
				br.close();
			}
		}
		return testReport;
	}
}

