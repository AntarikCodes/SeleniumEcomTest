package pageEvents;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageElements.checkoutPageElements;
import utlis.ElementFetch;

public class checkoutPageEvents {
    public static ElementFetch ele= new ElementFetch();
    public void verifyCheckoutPage(){
        try{
            BaseClass.waitTillElementLoaded(By.id(checkoutPageElements.continueButton),20);
            BaseClass.attachScreenshot(Status.PASS,"Checkout page verified");
        }catch (Exception e){
            BaseClass.logger.log(Status.FAIL,"Failed to load checkout page"+e.getMessage());
            Assert.fail();
        }
    }
    public void addDetails(){
        ele.getWebElement("ID",checkoutPageElements.firstName).sendKeys("Bruce");
        ele.getWebElement("ID",checkoutPageElements.lastName).sendKeys("Wayne");
        ele.getWebElement("ID",checkoutPageElements.postalCode).sendKeys("12345");
        BaseClass.logger.log(Status.PASS,"Details Entered");
        ele.getWebElement("ID",checkoutPageElements.continueButton).click();
    }
}
