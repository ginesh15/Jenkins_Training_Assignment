package Utilities;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int maxRetryCount = 2; // Set the maximum number of retries here
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
    	/***Check if the number of retries attempted is less than the maximum allowed retries.***/
        if (retryCount < maxRetryCount) {
            retryCount++; // Increment the retry count for this test method.
            return true; // Retry the test method
        }
        return false; // Do not retry further
    }
}
