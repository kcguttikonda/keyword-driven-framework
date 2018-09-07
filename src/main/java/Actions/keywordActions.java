package Actions;

import DataMapper.Identifiers;
import coreEngine.KeywordActionsReflection;
import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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
    public static Capture screen = new Capture();

    public static void openurl(String Identifier, String Locator, String InputData, String Action) {

        try{
            wait = new WebDriverWait(driver,30);
            driver.get(InputData);
            Thread.sleep(5000);
            screen.getScreenShotsofTest(driver);
        }
        catch (Exception e){
            System.out.println("unable open url"+e.getMessage());
        }
    }

    public static void createDriverInstance(String Browser,String BrowserDriverPath) {
        System.setProperty("webdriver.chrome.driver", BrowserDriverPath);
        System.setProperty("webdriver.firefox.driver", BrowserDriverPath);
        //System.setProperty("webdriver.safari.driver","C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\Drivers\\chromedriver.exe");
        try {
            if (Browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                WebElement html = driver.findElement(By.tagName("html"));
                html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
                html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

            } else if (Browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println(driver);
                /*Actions act = new Actions(driver);
                act.keyDown(Keys.CONTROL).sendKeys("-").keyUp(Keys.CONTROL).perform();
                act.keyDown(Keys.CONTROL).sendKeys("-").keyUp(Keys.CONTROL).perform();*/

                /*Thread.sleep(2000);
                Robot rt = new Robot();
                rt.keyPress(KeyEvent.VK_CONTROL);
                rt.keyPress(KeyEvent.VK_ADD);
                rt.keyRelease(KeyEvent.VK_ADD);
                rt.keyRelease(KeyEvent.VK_CONTROL);*/
            } else if (Browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                driver.manage().window().maximize();

            }
            screen.getScreenShotsofTest(driver);
        } catch (Exception e) {
            System.out.println("unable to invoke browser: " + e.getMessage());

        }
    }
    public static void clearandenter(String Identifier, String Locator, String InputData, String Action) {

        try{
            element =reflect.identifyLocator(Identifier,driver,Locator);
            element.clear();
            element.sendKeys(InputData);
            screen.getScreenShotsofTest(driver);
        }
        //reflect.getMethodsIdentifiers();
        catch (Exception e){
            System.out.println("Unable to clear/enter: "+e.getMessage());
        }

    }

    public static void enterText(String Identifier, String Locator, String InputData, String Action){
        //reflect.getMethodsIdentifiers();
        try {
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            element.sendKeys(InputData);
            screen.getScreenShotsofTest(driver);
        }
        catch (Exception e){
            System.out.println("Unable to enter text: "+e.getMessage());
        }
    }

    public static void click(String Identifier, String Locator, String InputData, String Action) {
        //reflect.getMethodsIdentifiers();
        try {
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            Thread.sleep(5000);
            screen.getScreenShotsofTest(driver);
        }
        catch (Exception e){
            System.out.println("Unable to click: "+e.getMessage());
        }
    }

    public static void clickAndWait(String Identifier, String Locator, String InputData, String Action) {
        //reflect.getMethodsIdentifiers();
        try {
            System.out.println("im in click and wait");
            element = reflect.identifyLocator(Identifier, driver, Locator);
            element.click();
            screen.getScreenShotsofTest(driver);
            System.out.println("im in click and wait-after click");
            int waittime = Integer.valueOf(InputData);
            Thread.sleep(waittime);
            System.out.println("waittime completed");
            //Thread.sleep(120000);
        }
        catch (Exception e){
            System.out.println("unable to click and wait:  "+e.getMessage());
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
            screen.getScreenShotsofTest(driver);
        }
        catch (Exception e){
            System.out.println("Unable to verify text: "+e.getMessage());
        }
    }
    public static void closeBrowser(String Identifier, String Locator, String InputData, String Action)
    {
        try {
            driver.quit();
        }
        catch (Exception e){
            System.out.println("Unable to close browser"+e.getMessage());
        }
    }

    public static void createConnection(String Identifier, String Locator, String InputData, String Action) throws InterruptedException {
            Map testmap = new LinkedHashMap();
            String[] inputInputDataArray = InputData.split(",");

            for (String str : inputInputDataArray) {
                String[] eachString =str.split(":",2);
                testmap.put(eachString[0], eachString[1]);
            }
            String currentURL = driver.getCurrentUrl();
            currentURL = currentURL.replace("applications","wistudio/connectiondetails");
            System.out.println(currentURL);
            driver.navigate().to(currentURL);
            Thread.sleep(60000);
            String connectorXpath = "//div[contains(@class,'wi-card-title-connector') and contains(text()," + testmap.get("Connector") + ")]";
            driver.findElement(By.xpath(connectorXpath)).click();
            screen.getScreenShotsofTest(driver);



            //driver.findElement(By.xpath("//p-dialog[@id='connectionListModal']/div/div[2]")).click();
            screen.getScreenShotsofTest(driver);
            WebElement html = driver.findElement(By.tagName("html"));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
            html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
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
            screen.getScreenShotsofTest(driver);
            System.out.println("Before Login Click");
            driver.findElement(By.xpath(loginButton)).click();
            System.out.println("After Login Click");
            screen.getScreenShotsofTest(driver);
            Thread.sleep(10000);
       // catch (Exception e){
            //System.out.println("unable to Create a Connection:  "+e.getMessage());

    }

}

