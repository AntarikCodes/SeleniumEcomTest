package utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BaseClass;
public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "XPATH":
                return BaseClass.driver.findElement(By.xpath(identifierValue));
            case "CLASSNAME":
                return BaseClass.driver.findElement(By.className(identifierValue));
            case "ID":
                return BaseClass.driver.findElement(By.id(identifierValue));
            case "LINKTEXT":
                return BaseClass.driver.findElement(By.linkText(identifierValue));
            case "NAME":
                return BaseClass.driver.findElement(By.name(identifierValue));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + identifierType);
        }
    }
}
