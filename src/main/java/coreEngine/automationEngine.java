package coreEngine;
import Actions.keywordActions;
import DataMapper.ConfigBuilder;
import DataMapper.TestCaseRowIndexes;
import DataMapper.TestDataVariables;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static DataMapper.ConfigBuilder.TestCasesPath;
import static DataMapper.ConfigBuilder.configReader;
import static DataMapper.TestCaseRowIndexes.testCaseRows;


public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();
    static TestDataVariables testdata = new TestDataVariables();

    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //ConfigBuilder configbuilder = new ConfigBuilder();
        configReader();
        ExcelReader reader = new ExcelReader();
        testcasesData = reader.TestCaseReader(TestCasesPath);
        TestCaseRowIndexes testcases = new TestCaseRowIndexes();
        testcases.buildTestCasesList(ConfigBuilder.TestCases, testcasesData);

        System.out.println(testcasesData.getLastRowNum());
        for (String key:testCaseRows.keySet()) {
            keywordActions.createDriverInstance(ConfigBuilder.Browser, ConfigBuilder.BrowserDriverPath);
            //System.out.println(key );
            for(int i=0;i<testCaseRows.get(key).size();i++) {
                System.out.println(testCaseRows.get(key).get(i));
                 testdata.setVariables(testcasesData, Integer.parseInt(testCaseRows.get(key).get(i).toString()));
                reflection.getMethods();
                reflection.performAction(TestDataVariables.Identifier, TestDataVariables.InputLocator, TestDataVariables.InputData, TestDataVariables.Action);
            }
        }


/*
        for (int id = 0; id < ConfigBuilder.numOfTestCases; id++) {

            testcasesData.getRow(id).getRowNum();

            for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {
                if (testcasesData.getRow(i) == null) {
                    continue;
                }
                testdata.setVariables(testcasesData, i);
                reflection.getMethods();
                reflection.performAction(TestDataVariables.Identifier, TestDataVariables.InputLocator, TestDataVariables.InputData, TestDataVariables.Action);
*/
    }
}