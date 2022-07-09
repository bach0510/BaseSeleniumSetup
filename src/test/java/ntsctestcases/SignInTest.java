package ntsctestcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import ntscpages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;


    @Test
    public void LoginTest(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://mkt-fe.4seslife.com/");

        // khoi tao login page
        SignInPage signin = new SignInPage(driver);

        signin.Login();

    }
}
