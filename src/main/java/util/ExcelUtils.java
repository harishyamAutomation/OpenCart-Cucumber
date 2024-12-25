package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Workbook workbook;
	private Sheet sheet;
	
	String testDataFilePath = PropertyReader.getData("testDataFilePath");
	
	public ExcelUtils(String sheetName) {
		try(FileInputStream fis = new FileInputStream(testDataFilePath)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ExcelUtils(String testDataFilePath, String sheetName) {
		try(FileInputStream fis = new FileInputStream(testDataFilePath)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//To keep Singleton Object
	public static ExcelUtils getTestDataFile(String sheetname) {
		ExcelUtils testdata=null;
		if(testdata==null) {
			testdata = new ExcelUtils(sheetname);
		}
		return testdata;
	}
	
	public String getCellData(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);		
		return cell==null?"":cell.toString();
	}
	
	public int getRowCount() {
		return sheet.getLastRowNum()+1;
	}
	
	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public void closeWorkBook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExcelUtils data = new ExcelUtils("AddCustomer");
		for(int i=1; i<data.getRowCount(); i++) {
			for(int j=0; j<data.getColCount(); j++) {
				System.out.print(data.getCellData(i, j)+"|");
			}
			System.out.println();
		}
	}
}
