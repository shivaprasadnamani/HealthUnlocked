package com.hu.webdriver.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Venkatesh.Aarelly
 *
 */
public class ExcelDataReader {
	/**
	 * parse the excel and return the data in selenium data provider format (2d
	 * array)
	 *
	 * @param xlFilePath
	 * @return
	 * @throws IOException
	 */
	public Object[][] getExcelDataArray(String xlFilePath,
			String sheetName, boolean isSkipHeader,boolean isXLSXFormat) throws IOException {
		Object[][] tableArray = null;
		InputStream st = null;
		Workbook wb;
		Sheet sheet;
		try {
			final File excelReport = new File(xlFilePath);
			while (!(excelReport.length() > 0)) {
				for (int timeout = 200; timeout > 0; timeout--) {
					// do nothing
				}
			}
			st = new FileInputStream(excelReport);
			if(isXLSXFormat)
			{
				wb =  WorkbookFactory.create(new File(xlFilePath));
			}else{
				wb = new HSSFWorkbook(st);
			}
			if (StringUtils.isEmpty(sheetName)) {
				// read only from first sheet
				sheet = wb.getSheetAt(0);
			} else {
				sheet = wb.getSheet(sheetName);
			}
			// if not skip header then table size will be (LastRow + 1)
			if (isSkipHeader) {
				tableArray = new Object[sheet.getLastRowNum()][];
			} else {
				tableArray = new Object[sheet.getLastRowNum() + 1][];
			}
			final Iterator<Row> rowIterator = sheet.iterator();

			// skip the header row
			if (rowIterator.hasNext() && isSkipHeader) {
				rowIterator.next();
			}

			int ci = 0;
			while (rowIterator.hasNext()) {
				final Row row = rowIterator.next();
				row.cellIterator();
				tableArray[ci] = new Object[row.getLastCellNum()];
				for (int i=0; i<row.getLastCellNum(); i++) {
					final Cell cell = row.getCell(i);
					tableArray[ci][i] = getValue(cell);
				}
				ci++;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (st != null)
				st.close();
		}

		return tableArray;
	}

	private Object getValue(Cell cell) {
		Object value = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = cell.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_ERROR:
				value = cell.getErrorCellValue();
				break;
			}
		}
		return value;
	}

}
