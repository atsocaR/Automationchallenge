package util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataTestReader {
	private static int numRows;
	private static Row row;
	private static Sheet dataSheet;
	
	private static Sheet getDataSheet(String fPath, String fName, String sheet) {
		File dataTestFile = null;
		FileInputStream streamFile =null;
		Workbook workBook =null;
		
		
		try {
			dataTestFile = new File(fPath+"\\"+fName);
			streamFile = new FileInputStream(dataTestFile);
			workBook = new XSSFWorkbook(streamFile);
			dataSheet = workBook.getSheet(sheet);
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex2){
			ex2.printStackTrace();
		}
		
		return dataSheet;
	}
	
	
	public static List<UserCredentials> getCredentials(String filePath, String fileName, String sheetName){
		List<UserCredentials> credentials = new ArrayList<UserCredentials>();
		UserCredentials userCredentials = null;
		String userName="";
		String password ="";
		
		dataSheet = getDataSheet(filePath, fileName, sheetName);
		numRows = dataSheet.getLastRowNum() - dataSheet.getFirstRowNum();
			
		for(int i=1; i<numRows +1; i++) {
			row = dataSheet.getRow(i);
			userName = row.getCell(0).getStringCellValue();
			password = row.getCell(1).getStringCellValue();
			userCredentials = new UserCredentials(userName, password); 
			credentials.add(userCredentials);
		}			
		
		return credentials;
	}
	
	
	public static String getUrl(String filePath, String fileName, String sheetName) {
		dataSheet = getDataSheet(filePath, fileName, sheetName);
		row= dataSheet.getRow(0);
		String url = row.getCell(0).getStringCellValue();
		return url; 
	}


	public static String getProductName(String filePath, String fileName, String sheetName){
		dataSheet = getDataSheet(filePath, fileName, sheetName);
		row = dataSheet.getRow(1);
		String productName = row.getCell(0).getStringCellValue();
		
		return productName;
	}


	public static String getInvalidLoginMsg(String filePath, String fileName, String sheetName) {
		dataSheet = getDataSheet(filePath, fileName, sheetName);
		row = dataSheet.getRow(1);
		String invalidLoginMessage = row.getCell(2).getStringCellValue();
		
		return invalidLoginMessage;
	}


	public static String getConfirmationPurchaseMsg(String filePath, String fileName, String sheetName) {
		dataSheet = getDataSheet(filePath, fileName, sheetName);
		row = dataSheet.getRow(1);
		String purchaseConfirmationMessage = row.getCell(0).getStringCellValue();
		
		return purchaseConfirmationMessage;
	}
}
