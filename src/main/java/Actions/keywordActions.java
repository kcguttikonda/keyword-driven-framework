package Actions;


import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class keywordActions
{

    public static String Browser;
    public static WebDriver driver;

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
    }

    public static void openurl(String url)
    {
        driver.get(url);
    }

    public static void clearandenter(){
        driver.findElement(By.id("")).clear();
        driver.findElement(By.id("")).sendKeys("");
    }

    public static void enter(){

        driver.findElement(By.id("")).sendKeys("");
    }

    public static void click(){

        driver.findElement(By.id("login")).click();
    }

    public static void waittime() throws Exception{
        Thread.sleep(5000);
    }

    public static void verifytext(String texttovalidate){
        driver.findElement(By.id("")).getText().equalsIgnoreCase(texttovalidate);
    }
    public static void closeBrowser(){
        driver.quit();
    }

}

