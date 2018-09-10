package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testing {


    public static void deleteApp(String appName) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tcidev-integration.sandbox.cloud.tibco.com/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@id='login']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gkchaitu277@dispostable.com");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='next']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tibco2018");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='taLogin']")).click();
        Thread.sleep(20000);



        String appNameLocator = "//div[contains(@class,'tropos-appbox-content-name-app ng-binding') and contains(text(),'"+appName+"')]";
        driver.findElement(By.xpath(appNameLocator)).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.id("appDetailShowDetail")).getText(),appName);

        driver.findElement(By.id("appDetailDropdownBtn")).click();
        driver.findElement(By.id("appDetailOpenDeleteDialogBtn")).click();
        driver.findElement(By.xpath("//div[@class='tropos-application-delete tc-modals ng-scope']"));
        driver.findElement(By.cssSelector(".div.modal-header"));
        String cancelButton = "(//button[@type='button'])[18]";
        driver.findElement(By.xpath(cancelButton)).click();

    }

@Test
public void test() throws InterruptedException {
    deleteApp("new");
}
}
