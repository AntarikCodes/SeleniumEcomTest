package utlis;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {
    int count=0;
    int retryCount=2;  //Number of retries
    public boolean retry(ITestResult result){
        if (count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}
