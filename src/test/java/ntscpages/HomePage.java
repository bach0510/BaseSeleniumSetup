package ntscpages;

import ntscbase.HandleAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    // luu tru thuoc tinh va cac thao tac doi voi man hinh login
    private WebDriver driver;
    private HandleAction handle;
    private WebDriverWait wait;

    public By headerUserName = By.xpath("//span[@class='kt-header__topbar-username kt-hidden-mobile']");// tên người dùng home
    public By headerTenantCode = By.xpath("//span[@class='kt-header__topbar-username kt-hidden-mobile']/span[1]");// mã đại lý home

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.handle = new HandleAction(driver);
    }

    public String getLoginInfo(){

        String name = handle.getText(headerUserName);
        return  name;
    }
}
