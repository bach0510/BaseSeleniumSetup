import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumTest {

    private static WebDriver driver;

    @Test
    public static void Test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
//        driver.get("https://www.youtube.com/watch?v=NSNTxlQdsBo");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());
//        WebDriverWait wait = new WebDriverWait(driver, 50);
//
//
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.id("search")
//        ));
        WebElement input = driver.findElement(By.xpath("//input[@id=\"search\"]"));

        WebElement searchBtn = driver.findElement((By.xpath("//button[@id=\"search-icon-legacy\"]")));

        //WebElement input2 =  (WebElement) ((JavascriptExecutor) driver).executeScript("document.getElementBy('search')");
        Thread.sleep(1000);
        input.sendKeys("Man on the moon female version");
        Thread.sleep(1000);

        searchBtn.click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");

//        driver.findElement(By.id("search-icon-legacy")).click();
//        driver.quit();
    }
}
