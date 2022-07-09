package ntscpages;

import ntscbase.HandleAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    // luu tru thuoc tinh va cac thao tac doi voi man hinh login
    private WebDriver driver;
    private HandleAction handle;

    private By tenancyNameInput = By.name("tenancyName");// ma dai ly
    private By usernameInput = By.name("userNameOrEmailAddress");
    private By passwordInput = By.name("password");

    private By loginBtn = By.xpath("//button[@type='submit']"); // button dang nhap

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.handle = new HandleAction(driver);
    }

    public void Login(){
//            Thread.sleep(2000);
//            handle.waitForPageLoad();
            // nhap ma dai ly
            handle.setText(tenancyNameInput,"TBMT");
            // nhap userName
            handle.setText(usernameInput, "TBMT_BACH");
            //nhap password
            handle.setText(passwordInput, "121200");
            //click
            handle.click(loginBtn);


    }


}
