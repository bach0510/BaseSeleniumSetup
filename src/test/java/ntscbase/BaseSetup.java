package ntscbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetup {
    private WebDriver driver;

    public WebDriver getDriver() {return driver;}

    private void setDriver(String browserType , String url){
        switch (browserType){
            case "chrome":
                driver = setChromeDriver(url);
                break;
            default:
                //driver = setChromeDriver(url);
                break;
        }
    }

    private WebDriver setChromeDriver(String url){
        WebDriverManager.chromedriver().setup();

        WebDriver newdriver = new ChromeDriver();
        newdriver.manage().window().maximize();
        newdriver.navigate().to(url);

        return newdriver;
    }

    @BeforeClass
    public void setUpTestBase () throws Exception{
        try{
            setDriver("chrome","https://mkt-fe.4seslife.com/");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws  Exception{
//        Thread.sleep(2000);
        driver.quit();
    }
}
