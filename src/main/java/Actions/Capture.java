package Actions;

import DataMapper.ConfigBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Random;

public class Capture {
        File screenshotFile;

    public void getScreenShotsofTest(WebDriver driver){

        try{
            Random rand = new Random();


            String path = ConfigBuilder.screenshotpath+"/"+"Screenshot"+rand.nextInt(1000)+".jpg";
            screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(path));

        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
