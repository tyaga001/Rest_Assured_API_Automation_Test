package CustomListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryListeners implements IRetryAnalyzer {

    int count=0;
    int maxRetry=3;

    public boolean retry(ITestResult arg0) {
        if(count<maxRetry)
        {
            count++;
            return true;
        }
        else
            return false;
    }
}
