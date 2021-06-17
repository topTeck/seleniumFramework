package personalPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		

		int first,last;
		first = 0;
		last = 0;
		
		String testID= "TC001_ValigLogin";
		
		String path = "F:\\TopTech Learning\\excel\\TestData.xlsx";
		File fl = new File(path);
		FileInputStream fls = new FileInputStream(fl);
		
		//create a woorkbook objhect
		Workbook wb = new XSSFWorkbook(fls);
		org.apache.poi.ss.usermodel.Sheet st    = wb.getSheet("Login");
		
		int firstRow = st.getFirstRowNum(); //0
		int lastRow  = st.getLastRowNum();  //2500
		
		System.out.println("FirstRow " + firstRow +  " and LAstRow number " + lastRow);
		
		//read and print the data
		int i;
		for(i = 0;i<lastRow; i++) {
			
			String id = st.getRow(i).getCell(1).getStringCellValue();
	
			if(id.equalsIgnoreCase(testID)) {
				first = i;
				break;
			}

		}		
		
		for(int j=i;j<=(lastRow+1);j++) {
			String id = st.getRow(j).getCell(1).getStringCellValue();
			
			if(!id.equalsIgnoreCase(testID)) {
				last = j;
				break;
			}
			
			if(j==lastRow) {
				last = j;
				break;
			}
		}
		int totalDataRows = last-first;
		
		Object[][] obj = new Object[totalDataRows][1];
		int val = 0;
		for(int k=first;k<last;k++) {
			Map<String,String> mp = new HashMap<String, String>();
			
			for(int l=0;l<st.getRow(k).getLastCellNum();l++) {		
				//add the data
				mp.put(st.getRow(0).getCell(l).getStringCellValue(), st.getRow(k).getCell(l).getStringCellValue());
			}
			
			obj[val][0] = mp;
			val++;
		}
	
		System.out.println(obj);
	}

}
