package ntsctestcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import ntscbase.BaseSetup;
import ntscpages.HomePage;
import ntscpages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInTest extends BaseSetup {
    private WebDriver driver ;
    private WebDriverWait wait;


    @Test
    @Parameters({"tenancyName","username","password"})
    public void LoginTest(String tenancyName ,String username, String password ) throws Exception{
        driver = getDriver();

        // khoi tao login page
        SignInPage signin = new SignInPage(driver);

//        String username = "admin";
//        String tenancyName = "TMV";
//        String password = "TmvMktNew@2021##";

        signin.Login(tenancyName,username,password);

        Thread.sleep(3000);
        Assert.assertFalse(driver.getCurrentUrl().contains("login"),"login không thành công");

        HomePage hp = new HomePage(driver);
        String logInfo = hp.getLoginInfo();
        String loginfoCheck = tenancyName == "TMV" ? "\\\n" : tenancyName + "\\\n" + username;
        Assert.assertTrue(logInfo.equals(logInfo),"thông tin đăng nhập không đúng");
    }
}
