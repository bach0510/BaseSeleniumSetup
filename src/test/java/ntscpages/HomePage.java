package ntscpages;

import ntscbase.HandleAction;
import ntscenum.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public By activeTab = By.xpath("//a[contains(@id,'link') and contains(@class,'active')]");// tab đang chọn
    public By menuItem = By.xpath("//a[@href='javascript:;' or  contains(@href,'/app')]");// chỉ mục đường dẫn menu và component

    public By menuSideBar = By.xpath("//div[@id='kt_aside_menu']"); // thanh side bar bên trái
    public By menuButton = By.xpath("//button[@id='kt_aside_toggler']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.handle = new HandleAction(driver);
    }

    public String getLoginInfo(){

        String name = handle.getText(headerUserName);
        return  name;
    }

    public String openComponent(String tabCode) throws InterruptedException {
        if (!driver.findElement(menuSideBar).isDisplayed()){
            handle.click(menuButton);
            handle.click(menuButton);
        }

        By element = By.xpath("//a[@href='/app/"+ tabCode +"']");
        String categoryName = driver.findElement(element).getAttribute("textContent");

        categoryName = categoryName.trim(); // cắt bỏ khoảng trắng giữa 2 đầu của menuName

        String itemNum = categoryName.split(" ")[0];// số thứ tự của item
        String[] listStt = itemNum.split("[.]");

        List<WebElement> categoryElement = driver.findElements(menuItem);

        int i = 0;
        String cateName = "";

        do{
            cateName += listStt[i] + ".";
            String finalCateName = cateName;
            WebElement catelem = categoryElement.stream().filter(x -> x.getText().split(" ")[0].equals(finalCateName)).findAny()
                    .orElse(null);
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", catelem);
            Actions actions = new Actions(driver);
            actions.moveToElement(catelem).click().build().perform();
            i++;
        } while (i < listStt.length && (listStt[i] != "" || listStt[i] != null));
        String name =categoryName.substring(categoryName.split(" ")[0].length()).trim() ;
        return name;
    }

    public List<WebElement> GetAllActiveTabHeader(){
        List<WebElement> activeTabs = driver.findElements(tabHeader);
        return activeTabs;
    }

    public String GetActiveTabHeaderName(){
        String activeTabName = handle.getText(activeTab).substring(0, handle.getText(activeTab).length() - 2);// trừ đi kí tự x màu đỏ trên thanh tab
        return activeTabName;
    }
}
