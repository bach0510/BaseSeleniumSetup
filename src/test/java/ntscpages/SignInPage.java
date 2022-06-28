package ntscpages;

import ntscbase.HandleAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    // luu tru thuoc tinh va cac thao tac doi voi man hinh login
    private WebDriver driver;

    private By tenancyNameInput = By.name("tenancyName");
    private By usernameInput = By.name("userNameOrEmailAddress");
    private By passwordInput = By.name("password");
//    private By passwordInput = By.name("password");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        HandleAction handle = new HandleAction(driver);
    }


}
