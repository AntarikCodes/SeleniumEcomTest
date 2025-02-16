package pageEvents;

import base.BaseClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageElements.overviewPageElements;
import utlis.ElementFetch;

public class overviewPageEvents {
    public static ElementFetch ele = new ElementFetch();

    public void verifyOverviewPage() {
        try {
            BaseClass.waitTillElementLoaded(By.id(overviewPageElements.finish), 20);
            BaseClass.attachScreenshot(Status.PASS, "Page loaded successfully!");
        } catch (Exception e) {
            BaseClass.logger.log(Status.FAIL,"Page not loaded"+e.getMessage());
            Assert.fail();
        }
    }
    public void totalPrice(){
        String priceText = ele.getWebElement("XPATH", overviewPageElements.price).getText();
        String tax = ele.getWebElement("XPATH", overviewPageElements.tax).getText();
        String totalPrice = ele.getWebElement("XPATH", overviewPageElements.totalPrice).getText();
        BaseClass.logger.log(Status.INFO, "Product Price:  " + priceText+" "+tax+" "+totalPrice);
    }
    public void clickFinish(){
        ele.getWebElement("ID",overviewPageElements.finish).click();
    }
}
