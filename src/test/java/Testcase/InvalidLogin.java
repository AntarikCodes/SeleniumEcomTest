package Testcase;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import pageEvents.loginPageEvents;

import java.io.IOException;

public class InvalidLogin extends BaseClass {
    loginPageEvents loginPage = new loginPageEvents();

    public void invalidLogin() throws IOException {
        logger.log(Status.INFO, "Verifying login page...");
        loginPage.verifyLoginPage();
        logger.log(Status.INFO,"Logging in...");
        loginPage.invalidLogin();
    }
}
