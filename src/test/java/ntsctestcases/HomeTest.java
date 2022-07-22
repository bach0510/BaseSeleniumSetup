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
    @Parameters({"tabName"})
    public void OpenComponent(String tabName) throws Exception{
        driver = getDriver();

        // khoi tao home page
        HomePage home = new HomePage(driver);
        var openedTabHeaders = home.GetAllActiveTabHeader();
        Assert.assertFalse(openedTabHeaders.size() == 10 , "Hiện đã có 10 tab đã mở , không thể mở thêm tab");

        home.openComponent(tabName);
    }
}
