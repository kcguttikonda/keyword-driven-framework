package DataMapper;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ConfigBuilder {

    public static List TestCases = new ArrayList();
    public static String Browser;
    public static String OS;
    public static String TestCasesPath;
    public static String BrowserDriverPath;
    public static int numOfTestCases;
    public static String screebshotpath;


    public static void configReader() {
        try{
            Yaml yaml = new Yaml();

            File configFile = new File("config.yml");

            FileInputStream configStream = new FileInputStream(configFile);

            Map<String,Object> configMap = (Map<String,Object>) yaml.load(configStream);

            System.out.println(configMap);

            if(configMap.get("TestCases").toString().contains("-"))
            {
                String[] testcaseRange = configMap.get("TestCases").toString().split("-");
                System.out.println(testcaseRange[0]);
                System.out.println(testcaseRange[1]);
                for(int i=Integer.parseInt(testcaseRange[0]);i<=Integer.parseInt(testcaseRange[1]);i++){
                    TestCases.add(i);
                }
            }
            else{
                String[] testcaseRange = configMap.get("TestCases").toString().split(",");
                for (String id:testcaseRange) {
                    TestCases.add(id);
                }
            }

            numOfTestCases = TestCases.size();
            Browser = configMap.get("Browser").toString();
            OS = configMap.get("OS").toString();
            TestCasesPath=configMap.get("TestCasesPath").toString();
            BrowserDriverPath=configMap.get("BrowserDriverPath").toString();
            screebshotpath =configMap.get("screenshotspath").toString();
        }
        catch (Exception e){
            System.out.println("Unable read config"+e.getMessage());
        }


    }
}