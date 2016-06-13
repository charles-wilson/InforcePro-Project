package DDT;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHandling {
	public static void main(String[] a) throws Exception {
		getData();
	}
	public static Object[][] getData() throws Exception {
		// TODO Auto-generated method stub

		File src=new File("/home/delhivery/InforcePro/TestData/InputData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		Workbook wb=new XSSFWorkbook(fis);
		
		Sheet sheet1=wb.getSheetAt(0);
		int rowCount=sheet1.getLastRowNum();
		int columnCount=sheet1.getRow(0).getLastCellNum();
		 Object[][] Arr2D=new Object[rowCount][columnCount];
		for(int i=1; i<=rowCount;i++){
			Row rowObj=sheet1.getRow(i);
			
			for(int j=0;j<=columnCount-1;j++){
				Cell cellObj=rowObj.getCell(j, Row.CREATE_NULL_AS_BLANK);
				String data=cellObj.getStringCellValue();
				Arr2D[i-1][j]=data;
			}
		}
		return Arr2D;
	
		
	}
	
	
}
