package pageEvents;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageElements.orderPageElements;
import utlis.ElementFetch;

public class orderPageEvents {
    public static ElementFetch ele = new ElementFetch();
    public void verifyOrder(){
        try {
            BaseClass.waitTillElementLoaded(By.id(orderPageElements.returnButton),20);
            BaseClass.logger.log(Status.PASS,"Order page loaded successfully!");
            String message=ele.getWebElement("XPATH",orderPageElements.orderMessage).getText();
            BaseClass.logger.log(Status.INFO,"Message:"+message);
            BaseClass.attachScreenshot(Status.PASS,"Order successfully!");
        } catch (Exception e) {
            BaseClass.logger.log(Status.FAIL,"Order failed"+e.getMessage());
            Assert.fail();
        }
    }
}
