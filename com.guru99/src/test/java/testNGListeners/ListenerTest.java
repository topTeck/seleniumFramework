package testNGListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{
	
	
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println(result.getName()+" test case failed");		
    }		
		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
	
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub		
    	
    	System.out.println(result.getName()+" test case started");
        		
    }		
	
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println(result.getName()+" test case executed successfully");
    }

}
