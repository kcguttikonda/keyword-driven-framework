package coreEngine;
import Actions.keywordActions;
import DataMapper.ConfigBuilder;
import DataMapper.TestDataVariables;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();
    static TestDataVariables testdata = new TestDataVariables();
    public static keywordActions actions1 = new keywordActions();




    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ConfigBuilder configbuilder = new ConfigBuilder();
        configbuilder.configReader();
        keywordActions.createDriverInstance(ConfigBuilder.Browser, ConfigBuilder.BrowserDriverPath);
        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader(ConfigBuilder.TestCasesPath);
        System.out.println(testcasesData.getLastRowNum());

        for (int id = 0; id < ConfigBuilder.numOfTestCases; id++) {

            testcasesData.getRow(id).getRowNum();

            for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {
                if (testcasesData.getRow(i) == null) {
                    continue;
                }
                testdata.setVariables(testcasesData, i);
                reflection.getMethods();
                reflection.performAction(TestDataVariables.Identifier, TestDataVariables.InputLocator, TestDataVariables.InputData, TestDataVariables.Action);

            }
        }
    }
}