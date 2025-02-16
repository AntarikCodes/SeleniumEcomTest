package pageEvents;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageElements.productsPageElements;
import utlis.ElementFetch;

public class productsPageEvents {
    public static ElementFetch ele= new ElementFetch();
    public void verifyProductsPage(){
        try{
            BaseClass.waitTillElementLoaded(By.id(productsPageElements.backPackCart),20);
            BaseClass.logger.log(Status.INFO,"check");
            BaseClass.attachScreenshot(Status.PASS,"Product page loaded successfully!");
        } catch (Exception e) {
            BaseClass.logger.log(Status.FAIL,"Login failed"+e.getMessage());
            Assert.fail();
        }
    }
    public void backpackAdd(){
        ele.getWebElement("ID", productsPageElements.backPackCart).click();
    }
    public void boltTshirtAdd(){
        ele.getWebElement("ID", productsPageElements.boltTshirt).click();
    }
    public void bikeLightAdd(){
        ele.getWebElement("ID", productsPageElements.bikeLight).click();
    }
    public void fleeceJacketAdd(){
        ele.getWebElement("ID", productsPageElements.fleeceJacket).click();
    }
    public void cart(){
        ele.getWebElement("XPATH", productsPageElements.cartButton).click();
    }
}
