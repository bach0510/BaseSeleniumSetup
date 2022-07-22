package ntscpages;

import ntscbase.HandleAction;
import ntscenum.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    // luu tru thuoc tinh va cac thao tac doi voi man hinh login
    private WebDriver driver;
    private HandleAction handle;
    private WebDriverWait wait;

    public By headerUserName = By.xpath("//span[@class='kt-header__topbar-username kt-hidden-mobile']");// tên người dùng home
    public By headerTenantCode = By.xpath("//span[@class='kt-header__topbar-username kt-hidden-mobile']/span[1]");// mã đại lý home

    public By tabHeader = By.xpath("//a[contains(@id,'link')]");// tab đã mở
    public By activeTab = By.xpath("//a[contains(@id,'link')] and a[contains(@class,'active')]");// tab đang chọn
    public By categoryItem = By.xpath("//a[@href='javascript:;']");// chỉ mục đường dẫn

    public By menuButton = By.xpath("//button[@id='kt_aside_toggler']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.handle = new HandleAction(driver);
    }

    public String getLoginInfo(){

        String name = handle.getText(headerUserName);
        return  name;
    }

    public String openComponent(String categoryName) throws InterruptedException {
        handle.click(menuButton);
        handle.click(menuButton);

        String itemNum = categoryName.split(" ")[0];// số thứ tự của item
        String[] listStt = itemNum.split(".");

        List<WebElement> categoryElement = driver.findElements(categoryItem);
        int i = 0;
        String cateName = "";
        do{
            cateName += listStt[i] + ".";
            String finalCateName = cateName;
            WebElement catelem = categoryElement.stream().filter(x -> x.getText().split(" ")[0] == finalCateName).findFirst().get();
            Thread.sleep(1000);
            catelem.click();
            i++;
        } while (i < listStt.length && (listStt[i] != "" || listStt[i] != null));

//        handle.click(element);
        String name = handle.getText(activeTab);
        return name;
    }

    public List<WebElement> GetAllActiveTabHeader(){
        List<WebElement> activeTabs = driver.findElements(tabHeader);
        return activeTabs;
    }
}
