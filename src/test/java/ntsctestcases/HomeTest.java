package ntsctestcases;

import ntscbase.BaseSetup;
import ntscpages.HomePage;
import ntscpages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeTest extends BaseSetup {
    private WebDriver driver ;

    @Test
    @Parameters({"tabCode"})
    public void OpenComponent(String tabCode) throws Exception{
        driver = getDriver();

        // khoi tao home page
        HomePage home = new HomePage(driver);

        home.openComponent(tabCode);
    }
}
