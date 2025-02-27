package Testcase;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pageEvents.loginPageEvents;

import java.io.IOException;

public class Invalidlogin extends BaseClass {
    loginPageEvents loginPage = new loginPageEvents();

    @Test
    public void invalidLoginTest() throws IOException {
        logger.log(Status.INFO, "Verifying login page...");
        loginPage.verifyLoginPage();

        logger.log(Status.INFO,"Logging in...");
        loginPage.invalidLogin();
        loginPage.verifyLoginError();
    }
}
