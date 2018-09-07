package coreEngine;
import Actions.keywordActions;
import DataMapper.ConfigBuilder;
import DataMapper.TestCaseRowIndexes;
import DataMapper.TestDataVariables;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import static DataMapper.ConfigBuilder.TestCasesPath;


public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();
    static TestDataVariables testdata = new TestDataVariables();
    static ExcelReader reader;

    @BeforeMethod
    public void Setup(){
        //ConfigBuilder.configReader();
        reader = new ExcelReader();
        testcasesData = reader.TestCaseReader(TestCasesPath);
        TestCaseRowIndexes testcases = new TestCaseRowIndexes();
        testcases.buildTestCasesList(ConfigBuilder.TestCases, testcasesData);
        keywordActions.createDriverInstance(ConfigBuilder.Browser, ConfigBuilder.BrowserDriverPath);
    }

    @Test(dataProvider = "testCaseIds", dataProviderClass = ConfigBuilder.class)
    public void Engine(String testCaseId) throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
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

        }
            //catch (Exception e){
            //System.out.println("test case fail"+e.getMessage());

    @AfterMethod
    public void TearDown(){
        keywordActions.driver.quit();

    }

}