package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	
	public static String[][] retSheetData(String path,String sheetName) throws Exception
	{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		String data=sheet.getRow(0).getCell(0).toString();
		System.out.println(data);
		
		int row=sheet.getLastRowNum();
		int cell=sheet.getRow(0).getLastCellNum()-1;
	
		String fullData[][]=new String[row][cell];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				
				data=sheet.getRow(i).getCell(j).toString();
				
				fullData[i][j]=data;
				
				//System.out.print(data+"\t");
				
			}
			//System.out.println();
		}
		
		
		return fullData;
		
		
	}

	
	
	public static String retCellData(String path,String sheetName,int row,int col) throws Exception
	{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		String data=sheet.getRow(row).getCell(col).toString();
		System.out.println(data);
		return data;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		String fullData[][]=retSheetData(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx","URLs");
		for(int i=0;i<fullData.length;i++)
		{
			for(int j=0;j<fullData[1].length;j++)
			{
			
				System.out.println(fullData[i][j]);
			}
		}
	}

}
