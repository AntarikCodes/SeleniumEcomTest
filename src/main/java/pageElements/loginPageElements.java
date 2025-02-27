package pageElements;

public interface loginPageElements {
    String loginText="//div[@class='login_logo']";
    String username ="user-name";
    String password="password";
    String loginButton="login-button";
    String loginError="//h3[text()='Epic sadface: Username and password do not match any user in this service']";
}
