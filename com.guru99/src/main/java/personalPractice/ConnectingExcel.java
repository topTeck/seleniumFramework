package personalPractice;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConnectingExcel {
	
	
	public String testCaseID = "TC001_ValigLogin";
	public String sheetName  = "login";
	
	@BeforeClass
	void openBrowser() {
		System.out.println("opeing the browser");
	}
	
	@AfterClass
	void closeBrowser(){
		System.out.println("closeing the browser");
	}
	
	@Test(dataProvider = "getData")
	void TC001_Login(Map<String,String> mp) {
		
		
		
		
		System.out.println(mp.get("Execute"));
		System.out.println(mp.get("TestID"));
		System.out.println(mp.get("TestScenario"));
		System.out.println(mp.get("Execute"));
		System.out.println(mp.get("Execute"));
		
		//open browser
		//login
		//logout and close browser
		
	}

	
	
	@DataProvider
	Object[][] getData() throws IOException{
		excelUtil el = new excelUtil();
		return el.getTestData(testCaseID, sheetName);
	}
	
}
