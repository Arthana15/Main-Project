package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;


public class ExcelUtility {
	
	static FileInputStream f;//class to fetch predefined 
	static XSSFWorkbook w;
	static XSSFSheet s;
	public static String getStringData(int a,int b,String sheet) throws IOException 
	{
		f=new FileInputStream(Constants.TESTDATAFILE);
		//f=new FileInputStream("C:\\Users\\artha\\eclipse-workspace\\7rmartSupermarket\\src\\test\\resources\\TestData.xlsx");
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	public static String getIntegerdata(int a,int b,String sheet) throws IOException
	{
		//f=new FileInputStream("C:\\Users\\artha\\eclipse-workspace\\7rmartSupermarket\\src\\test\\resources\\TestData.xlsx");
		f=new FileInputStream(Constants.TESTDATAFILE);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y=(int) c.getNumericCellValue();
		return String.valueOf(y);
		
	}

}
