package ntscpages;

import ntscbase.BaseSetup;
import ntscbase.HandleAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignInPage  {
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

    public void Login(String tenancyName, String username, String password){
            // nhap ma dai ly
            handle.setText(tenancyNameInput,tenancyName);
            // nhap userName
            handle.setText(usernameInput, username);
            //nhap password
            handle.setText(passwordInput, password);
            //click
            handle.click(loginBtn);
    }

}
