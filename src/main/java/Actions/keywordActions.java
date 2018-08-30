package Actions;


import DataMapper.Identifiers;

import coreEngine.KeywordActionsReflection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;


public class keywordActions
{
    public static WebDriver driver;
    public static Identifiers idetifier;
    public static WebElement element;
    static WebDriverWait wait;
    public static KeywordActionsReflection reflect = new KeywordActionsReflection();

    public static void openurl(String Identifier, String Locator, String InputData, String Action) throws InterruptedException {


        wait = new WebDriverWait(driver,30);
        driver.get(InputData);
        Thread.sleep(5000);

    }

    public static void createDriverInstance(String Browser,String Driverpath){
        System.setProperty("webdriver.chrome.driver",Driverpath);
        System.setProperty("webdriver.firefox.driver",Driverpath);
        //System.setProperty("webdriver.safari.driver","C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\Drivers\\chromedriver.exe");
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

