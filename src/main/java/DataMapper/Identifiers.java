package DataMapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Identifiers {



public WebElement xpath(WebDriver driver,String locator){

    WebElement element = driver.findElement(By.xpath(locator));

    return element;

}

public WebElement linktext(WebDriver driver,String locator){

    WebElement element = driver.findElement(By.linkText(locator));
    return element;
}


public  WebElement id(WebDriver driver,String locator){

    WebElement element = driver.findElement(By.id(locator));
    return element;
}

public  WebElement className(WebDriver driver,String locator){

    WebElement element = driver.findElement(By.className(locator));
    return element;
}

    public  WebElement partialText(WebDriver driver,String locator){

        WebElement element = driver.findElement(By.partialLinkText(locator));
        return element;
    }

    public  WebElement CSS(WebDriver driver,String locator){

        WebElement element = driver.findElement(By.cssSelector(locator));
        return element;
    }



}
