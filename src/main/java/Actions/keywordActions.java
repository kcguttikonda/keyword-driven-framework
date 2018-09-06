package Actions;

import DataMapper.Identifiers;
import coreEngine.KeywordActionsReflection;
import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class keywordActions
{
    public static WebDriver driver;
    public static Identifiers idetifier;
    public static WebElement element;
    static WebDriverWait wait;
    public static KeywordActionsReflection reflect = new KeywordActionsReflection();

    public static void openurl(String Identifier, String Locator, String InputData, String Action) {

        try{
            wait = new WebDriverWait(driver,30);
            driver.get(InputData);
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println("unable open url"+e.getMessage());
        }
    }

    public static void createDriverInstance(String Browser,String Driverpath) {
        System.setProperty("webdriver.chrome.driver", Driverpath);
        System.setProperty("webdriver.firefox.driver", Driverpath);
        //System.setProperty("webdriver.safari.driver","C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\Drivers\\chromedriver.exe");
        try {
            if (Browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (Browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println(driver);
            } else if (Browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                driver.manage().window().maximize();

            }
        } catch (Exception e) {
            System.out.println("unable to invoke browser" + e.getMessage());

        }
    }
    public static void clearandenter(String Identifier, String Locator, String InputData, String Action) {

        try{
            element =reflect.identifyLocator(Identifier,driver,Locator);
            element.clear();
            element.sendKeys(InputData);
        }
        //reflect.getMethodsIdentifiers();
        catch (Exception e){
            System.out.println("unabele to clear/enter"+e.getMessage());
        }

    }

    public static void enterText(String Identifier, String Locator, String InputData, String Action){
        //reflect.getMethodsIdentifiers();
        try {
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            element.sendKeys(InputData);
        }
        catch (Exception e){
            System.out.println("unabele to enter text"+e.getMessage());
        }
    }

    public static void click(String Identifier, String Locator, String InputData, String Action) {
        //reflect.getMethodsIdentifiers();
        try {
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println("unabele to click"+e.getMessage());
        }
    }

    public static void clickAndWait(String Identifier, String Locator, String InputData, String Action) {
        //reflect.getMethodsIdentifiers();
        try {
            System.out.println("im in click and wait");
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            System.out.println("im in click and wait-after click");
            int waittime = Integer.valueOf(InputData);
            Thread.sleep(waittime);
            System.out.println("waittime completed");
            //Thread.sleep(120000);
        }
        catch (Exception e){
            System.out.println("unable to click and wait "+e.getMessage());
        }
    }


    public static void waittime(String Identifier, String Locator, String InputData, String Action) {
        try {
            int waittime = Integer.parseInt(InputData);
            Thread.sleep(waittime);
        }
        catch (Exception e){
            System.out.println("Thread"+e.getMessage());
        }
    }

    public static void verifytext(String Identifier, String Locator, String InputData, String Action) {
        //reflect.getMethodsIdentifiers();
        try {
            reflect.identifyLocator(Identifier, driver, Locator);
            element.getText().equalsIgnoreCase(InputData);
        }
        catch (Exception e){
            System.out.println("unabele to verify text"+e.getMessage());
        }
    }
    public static void closeBrowser(String Identifier, String Locator, String InputData, String Action)
    {
        try {
            driver.quit();
        }
        catch (Exception e){
            System.out.println("unabele to close browser"+e.getMessage());
        }
    }

    public static void createConnection(String Identifier, String Locator, String InputData, String Action)
    {
        try {
            Map testmap = new LinkedHashMap();
            String[] inputInputDataArray = InputData.split(",");

            for (String str : inputInputDataArray) {
                String[] eachString =str.split(":",2);
                testmap.put(eachString[0], eachString[1]);

            }
            driver.findElement(By.linkText("Connections")).click();
            Thread.sleep(40000);

            String connectorXpath = "//div[contains(@class,'wi-card-title-connector') and contains(text()," + testmap.get("Connector") + ")]";
            driver.findElement(By.xpath(connectorXpath)).click();
            driver.findElement(By.xpath("//p-dialog[@id='connectionListModal']/div/div[2]")).click();
            testmap.remove("Connector");

            Set<String> keys = testmap.keySet();
            for (String locatorName : keys) {
                String currentElement = locatorName.toString();
                String currentElementValue = (testmap.get(locatorName).toString()).replace("'", "");
                if (currentElement.toLowerCase().contains("select")) {
                    String selectLocator = currentElement.split("_")[1];
                    String currentElementXpath = "//select[@id=" + "'" + selectLocator + "']";
                    WebElement selectHandler = driver.findElement(By.xpath(currentElementXpath));
                    Select dropDown = new Select(selectHandler);
                    dropDown.selectByValue(currentElementValue);

                } else {
                    String currentElementXpath = "//input[@id=" + "'" + currentElement + "']";
                    driver.findElement(By.xpath(currentElementXpath)).sendKeys(currentElementValue);
                }
            }

            String loginButton = "(//button[@type='button'])[8]";
            driver.findElement(By.xpath(loginButton)).click();
            Thread.sleep(10000);
        }
        catch (Exception e){
            System.out.println("unable to close browser: "+e.getMessage());
        }
    }

}

