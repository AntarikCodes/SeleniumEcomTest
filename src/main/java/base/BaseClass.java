package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utlis.ElementFetch;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utlis.SuiteListeners.captureScreenshot;

public class BaseClass {
    public static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ElementFetch ele= new ElementFetch();

    @BeforeTest
    public void setupextentReport(){
        LocalDateTime myDate =LocalDateTime.now();
        DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd-MM_yyyy HH-mm-ss");
        String formattedDate=myDate.format(myFormat);
        sparkReporter = new ExtentSparkReporter("C:\\Users\\USER\\IdeaProjects\\ECommerceTesting\\src\\Reports\\"+formattedDate+".html");
        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Final Test Report");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void loadWebsite(Method testMethod, String browser){
        logger=extent.createTest(testMethod.getDeclaringClass().getName());
        logger.log(Status.INFO,"Executing:"+testMethod.getName());
        setUpBrowser(browser);
        logger.log(Status.INFO,"Browser used:Chrome");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method testMethod) throws IOException {
        String className=testMethod.getDeclaringClass().getSimpleName();
        String screenshotPath= captureScreenshot(result.getMethod().getMethodName());
        if (result.getStatus()==ITestResult.FAILURE){
            logger.log(Status.FAIL,"Test Failed:"+className);
            logger.log(Status.FAIL,"Failure Details:"+result.getThrowable());
            logger.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus()==ITestResult.SUCCESS) {
            logger.log(Status.PASS,"Test Passed:"+className);
        }
        //driver.close();
    }

    @AfterTest
    public void tearDown(){
        extent.flush();
        //driver.quit();
    }


    public void setUpBrowser(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }
    public static void waitTillElementLoaded(By locator, int timeSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitTillElementClickable(By locator, int timeSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public static void waitTillElementRemoved(By locator,int timeSeconds){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static void scrollUp(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
    }
    public static void scrollDown(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
    public static void scrollToElement(String identifierType, String identifierValue){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele.getWebElement(identifierType,identifierValue));
    }
    public static void javascriptClick(String identifierType, String identifierValue){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",ele.getWebElement(identifierType,identifierValue));
    }
    public static void waitForPageLoad(int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        {
            wait.until(d->{
                JavascriptExecutor js=(JavascriptExecutor) driver;
                return js.executeScript("return document.readyState").toString().equals("complete");
            });
        }
    }
    public static void attachScreenshot(Status logLevel, String message) throws IOException {
        String filename = captureScreenshot("screenshot");
        logger.log(logLevel, message, MediaEntityBuilder.createScreenCaptureFromPath(filename).build());

    }
}
