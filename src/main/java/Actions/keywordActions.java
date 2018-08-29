package Actions;


import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class keywordActions
{
    public static WebDriver driver;

    static WebDriverWait wait;
    public static void openBrowser(String Browser){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\Drivers\\chromedriver.exe");
        if(Browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        else if(Browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            System.out.println(driver);
        }
        else if (Browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
       wait = new WebDriverWait(driver,30);
    }

    public static void openurl(String Identifier, String Locator, String InputData, String Action) throws InterruptedException {
        driver.get(InputData);
        Thread.sleep(5000);

    }

    public static void clearandenter(String Identifier, String Locator, String InputData, String Action){

        driver.findElement(By.xpath(Locator)).clear();
        driver.findElement(By.xpath(Locator)).sendKeys(InputData);
    }

    public static void enter(String Identifier, String Locator, String InputData, String Action){

        driver.findElement(By.id(Locator)).sendKeys(InputData);
    }

    public static void click(String Identifier, String Locator, String InputData, String Action) throws InterruptedException {

        driver.findElement(By.xpath(Locator)).click();
        Thread.sleep(5000);
    }

    public static void waittime(String Identifier, String Locator, String InputData, String Action) throws Exception{
        Thread.sleep(5000);
    }

    public static void verifytext(String Identifier, String Locator, String InputData, String Action){
        driver.findElement(By.id("")).getText().equalsIgnoreCase(InputData);
    }
    public static void closeBrowser()
    {
        driver.quit();
    }

}

