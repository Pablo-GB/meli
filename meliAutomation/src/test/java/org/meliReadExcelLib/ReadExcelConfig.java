package org.meliReadExcelLib;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ReadExcelConfig(String path) 
	{
		File src =new File(path);
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
			 
		} 
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());		

		}

	}
	
	
	public String getData(int sheetNumber, int row, int column)
	{
		
		sheet1= wb.getSheetAt(sheetNumber);
		String data= sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	
	}
	
	public int getSheetRowNumber(int sheetNumber)
	{
		int rownumber=wb.getSheetAt(sheetNumber).getLastRowNum();
		rownumber=rownumber+1;
		return rownumber;
		
	}

}
