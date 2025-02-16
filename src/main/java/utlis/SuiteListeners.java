package utlis;
import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;

public class SuiteListeners implements ITestListener, IAnnotationTransformer {
    public static String captureScreenshot(String methodName) throws IOException {
        String filename= System.getProperty("user.dir") + "/Screenshot/"+methodName+".png";
        File screenshotFile  =((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File(filename));
        return filename;
    }
    public void transform(ITestAnnotation annotation){
        annotation.setRetryAnalyzer(retryAnalyzer.class);
    }
}
