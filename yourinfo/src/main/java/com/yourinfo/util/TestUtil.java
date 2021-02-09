package com.yourinfo.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.youinfo.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
	}
	public static long Page_Load_Timeout = 40;
	public static long Implicit_Wait = 40;
	
	static Workbook book;
	static Sheet sheet;

	public static Object[][]getTestData(String SheetName) throws InvalidFormatException, IOException
	{
		FileInputStream file = null;
		
	    file = new FileInputStream("C:\\Users\\Priyank\\eclipse-workspace"
	    		+ "\\yourinfo\\src\\main\\java\\com\\youinfo\\testdata\\YourInfoTestData.xlsx");
	    book = WorkbookFactory.create(file);
		sheet = book.getSheet(SheetName);
		
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
}
