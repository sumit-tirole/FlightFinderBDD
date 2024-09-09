package RetryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.HashMap;
import java.util.Map;


public class RetryAnalyzer implements IRetryAnalyzer {
    public static int retryCount = 0;
    public static final int maxRetryCount = 1;

    // Store retried tests and their final status
    public static final Map<String, Boolean> retryStatus = new HashMap<>();

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        } else {
            retryStatus.put(result.getName(), result.isSuccess());
            return false;
        }
    }


    public static Map<String, Boolean> getRetryStatus() {
        return retryStatus;
    }
}