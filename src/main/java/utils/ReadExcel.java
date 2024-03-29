package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel{

	public static String[][] getSheet(String dataSheetName) {

		String[][] data = null ;

		try {
			FileInputStream fis = new FileInputStream("./data/"+dataSheetName+".xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];
			DataFormatter df = new DataFormatter();
			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								// Based on Cell Type reading the content from Cell				
									cellValue = df.formatCellValue(row.getCell(j));
							}catch(NullPointerException e){
								e.printStackTrace();
							}
							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
