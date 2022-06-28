package ntscbase;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver , 20);
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                // kiem tra xem trang thai cuar window da ready hay chua ? (equal trar veef true false)
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        try {
            wait.until(expectation);
        } catch (Throwable error ){
            Assert.fail("Page load Timeout");
        }
    }

//    public void setText(By elem, String text  ){
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        driver.findElement(elem).clear();
//        driver.findElement(elem).sendKeys(text);
//    }
//
//    public void click(By elem){
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        driver.findElement(elem).click();
//    }
//
//    public void selectOptionByText(By elem,String text){
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        Select select =  new Select(driver.findElement(elem));
//        select.selectByVisibleText(text);
//    }
//
//    public void selectOptionByValue(By elem,String value){
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        Select select =  new Select(driver.findElement(elem));
//        select.selectByValue(value);
//    }
}
