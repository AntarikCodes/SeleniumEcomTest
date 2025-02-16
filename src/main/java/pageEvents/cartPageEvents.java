package pageEvents;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageElements.cartPageElements;
import utlis.ElementFetch;

public class cartPageEvents {
    public static ElementFetch ele= new ElementFetch();
    public void verifyCartPage(){
        try{
            BaseClass.waitTillElementLoaded(By.id(cartPageElements.checkout),20);
            BaseClass.attachScreenshot(Status.PASS,"Successfully loaded cart page");
        }catch (Exception e){
            BaseClass.logger.log(Status.PASS,"Failed loading cart page");
            Assert.fail();
        }
    }
    public  void proceedToCheckout(){
        ele.getWebElement("ID", cartPageElements.checkout).click();
    }
}
