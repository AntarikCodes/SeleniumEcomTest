package pageEvents;
import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utlis.ElementFetch;
import pageElements.loginPageElements;


import java.io.IOException;

public class loginPageEvents {
    public static ElementFetch ele= new ElementFetch();
    public void verifyLoginPage(){
        try{
            BaseClass.waitTillElementLoaded(By.id(loginPageElements.loginButton),20);
            BaseClass.logger.log(Status.PASS,"Login page loaded!");
        }catch (NoSuchElementException e){
            BaseClass.logger.log(Status.FAIL,"Login page loading failed"+ e.getMessage());
            Assert.fail();
        }
    }
    public void login() throws IOException {
        BaseClass.waitTillElementLoaded(By.xpath(loginPageElements.loginText),20);
        ele.getWebElement("ID",loginPageElements.username).sendKeys("standard_user");
        ele.getWebElement("ID",loginPageElements.password).sendKeys("secret_sauce");
        BaseClass.attachScreenshot(Status.PASS,"Details entered successfully!");
        ele.getWebElement("ID",loginPageElements.loginButton).click();
        BaseClass.logger.log(Status.PASS, "Login button clicked");
    }
    public void invalidLogin() throws IOException {
        BaseClass.waitTillElementLoaded(By.xpath(loginPageElements.loginText),20);
        ele.getWebElement("ID",loginPageElements.username).sendKeys("wrongID");
        ele.getWebElement("ID",loginPageElements.password).sendKeys("secret_sauce");
        BaseClass.attachScreenshot(Status.PASS,"Details entered successfully!");
        ele.getWebElement("ID",loginPageElements.loginButton).click();
        BaseClass.logger.log(Status.PASS, "Login button clicked");
    }
    public void verifyLoginError(){
        BaseClass.waitTillElementLoaded(By.xpath(loginPageElements.loginError),20);
        String errorText= ele.getWebElement("XPATH",loginPageElements.loginError).getText();
        BaseClass.logger.log(Status.PASS,"Login failed successfully!");
        BaseClass.logger.log(Status.INFO,"Error message: "+ errorText);
    }
}
