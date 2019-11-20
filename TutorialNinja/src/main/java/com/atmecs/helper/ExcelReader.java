package com.atmecs.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private Workbook workBookname = null;
	private Sheet sheetname = null;
	private Row rowindex = null;
	private Cell cellname = null;
	private String cellValue;

	public String getdata(String filename, String sheetName, String columnName, int rowIndex) throws Exception {
		int columnIndex = -1;
		File getfile = new File(filename);
		FileInputStream fileInputStream = new FileInputStream(getfile);
		workBookname = new XSSFWorkbook(fileInputStream);
		int index = workBookname.getSheetIndex(sheetName);
		sheetname = workBookname.getSheetAt(index);
		rowindex = sheetname.getRow(0);
		for (int i = 0; i < rowindex.getLastCellNum(); i++) {
			if (rowindex.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
				columnIndex = i;
			}
		}
		rowindex = sheetname.getRow(rowIndex);
		cellname = rowindex.getCell(columnIndex);
		cellValue = cellname.getStringCellValue();
		fileInputStream.close();
		return cellValue;
	}
}
