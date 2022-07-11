package ntscbase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;

public class HandleAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public HandleAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver , 20);
    }

    public void setText(By elem, String text  ){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(text);
    }

    public String getText(By elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        return driver.findElement(elem).getText();
    }

    public void click(By elem) {
//        waitForElemEnable(elem);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        driver.findElement(elem).click();
    }

    public void selectOptionByText(By elem,String text){
        waitForPageLoad();
        Select select =  new Select(driver.findElement(elem));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(By elem,String value){
        waitForPageLoad();
        Select select =  new Select(driver.findElement(elem));
        select.selectByValue(value);
    }

    public void waitForSeconds(int time) throws InterruptedException{
        int i = time* 1000;
        Thread.sleep(i);
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

}
