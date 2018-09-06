package DataMapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Identifiers {

    WebDriverWait wait;

    public WebElement xpath(WebDriver driver,String locator)  {

        WebElement element=null;
        try {


            System.out.println("inside" + locator);

 /*wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)),
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))
        ));*/
            Thread.sleep(3000);
            element = driver.findElement(By.xpath(locator));




        }
        catch (Exception e){
            System.out.println("Invoke browser "+e.getMessage());
        }
        return element;
    }

    public WebElement linktext(WebDriver driver,String locator){
        WebElement element=null;

        try {
            element = driver.findElement(By.linkText(locator));

        }

        catch (Exception e)
        {
            System.out.println("unable to find linktext"+locator+" "+e.getMessage());
        }

        return element;
    }


    public  WebElement id(WebDriver driver,String locator){
        WebElement element=null;
        try
        {
            element = driver.findElement(By.id(locator));
        }
        catch (Exception e){
            System.out.println("unable to find id"+locator+" "+e.getMessage());
        }
        return element;
    }

    public  WebElement className(WebDriver driver,String locator){
        WebElement element=null;
        try
        {
            element = driver.findElement(By.className(locator));
        }
        catch (Exception e){
            System.out.println("unable to find classname"+locator+" "+e.getMessage());
        }
        return element;

    }

    public  WebElement partialText(WebDriver driver,String locator){

        WebElement element=null;
        try
        {
            element = driver.findElement(By.partialLinkText(locator));
        }
        catch (Exception e){
            System.out.println("unable to find paritaltext"+locator+" "+e.getMessage());
        }
        return element;
    }

    public  WebElement CSS(WebDriver driver,String locator){


        WebElement element=null;
        try
        {
            element = driver.findElement(By.cssSelector(locator));
        }
        catch (Exception e){
            System.out.println("unable to find css"+locator+" "+e.getMessage());
        }
        return element;
    }



}
