package Actions;


import DataMapper.Identifiers;
import coreEngine.KeywordActionsReflection;
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

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class keywordActions
{
    public static WebDriver driver;
    public static Identifiers idetifier;
    public static WebElement element;
    static WebDriverWait wait;
    public static KeywordActionsReflection reflect = new KeywordActionsReflection();
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

    public static void clearandenter(String Identifier, String Locator, String InputData, String Action) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //reflect.getMethodsIdentifiers();
        element =reflect.identifyLocator(Identifier,driver,Locator);
        element.clear();
        element.sendKeys(InputData);
    }

    public static void enterText(String Identifier, String Locator, String InputData, String Action)throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        //reflect.getMethodsIdentifiers();
        element =reflect.identifyLocator(Identifier,driver,Locator);
        element.sendKeys(InputData);
    }

    public static void click(String Identifier, String Locator, String InputData, String Action) throws InterruptedException , NoSuchMethodException,InvocationTargetException ,IllegalAccessException{
        //reflect.getMethodsIdentifiers();
        element =reflect.identifyLocator(Identifier,driver,Locator);
        element.click();
        Thread.sleep(5000);
    }

    public static void waittime(String Identifier, String Locator, String InputData, String Action) throws Exception{
        Thread.sleep(5000);
    }

    public static void verifytext(String Identifier, String Locator, String InputData, String Action) throws InterruptedException , NoSuchMethodException,InvocationTargetException ,IllegalAccessException{
        //reflect.getMethodsIdentifiers();
        element =reflect.identifyLocator(Identifier,driver,Locator);
        element.getText().equalsIgnoreCase(InputData);
    }
    public static void closeBrowser(String Identifier, String Locator, String InputData, String Action)
    {
        driver.quit();
    }

}

