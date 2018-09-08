package coreEngine;
import Actions.keywordActions;
import DataMapper.ConfigBuilder;
import DataMapper.ExcelReader;
import DataMapper.TestCaseRowIndexes;
import DataMapper.TestDataVariables;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataMapper.ConfigBuilder.TestCasesPath;


public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();
    static TestDataVariables testdata = new TestDataVariables();
    static ExcelReader reader;

    @BeforeMethod
    public void Setup(){
        //ConfigBuilder.configReader();
        try{
            reader = new ExcelReader();
            testcasesData = reader.TestCaseReader(TestCasesPath);
            TestCaseRowIndexes testcases = new TestCaseRowIndexes();
            testcases.buildTestCasesList(ConfigBuilder.TestCases, testcasesData);
            keywordActions.createDriverInstance(ConfigBuilder.Browser, ConfigBuilder.BrowserDriverPath);
        }
        catch (Exception e){
            System.out.println("unable to setup"+e.getMessage());
            Assert.fail("Configuration failed");
        }

    }

    @Test(dataProvider = "testCaseIds", dataProviderClass = ConfigBuilder.class)
    public void Engine(String testCaseId)  {
       try{
           System.out.println("Im in the @Test Method" +testCaseId);


           System.out.println("Printing parameters form dataprovifrt" +testCaseId);
           System.out.println(String.format("Executing TestCase with ID: %S", testCaseId));
           for (int i = 0; i < TestCaseRowIndexes.testCaseRows.get(testCaseId).size(); i++) {
               System.out.println(TestCaseRowIndexes.testCaseRows.get(testCaseId).get(i));
               testdata.setVariables(testcasesData, Integer.parseInt(TestCaseRowIndexes.testCaseRows.get(testCaseId).get(i).toString()));
               reflection.getMethods();
               reflection.performAction(TestDataVariables.Identifier, TestDataVariables.InputLocator, TestDataVariables.InputData, TestDataVariables.Action);
           }
           System.out.println(String.format("Executing Completes for TestCase with ID: %S", testCaseId));
           //Assert.fail("Test failed");
       }
       catch (Exception e){
           System.out.println("Unable to read class" +testCaseId);
           Assert.fail("Test Case Execution failed");

       }


        }
            //catch (Exception e){
            //System.out.println("test case fail"+e.getMessage());

    @AfterMethod
    public void TearDown(){
        keywordActions.driver.quit();

    }

}