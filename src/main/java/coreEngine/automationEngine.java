package coreEngine;
import Actions.keywordActions;
import DataMapper.TestDataVariables;
import DataMapper.ExcelReader;
import DataMapper.TestDataVariables;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();
    static TestDataVariables testdata = new TestDataVariables();
    static keywordActions actions;

    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader("C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());

        for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {

            testdata.setVariables(testcasesData,i);
            if(i==1){
                keywordActions.openBrowser(TestDataVariables.Browser);
            }

            reflection.getMethods();

            reflection.performAction(TestDataVariables.Identifier,TestDataVariables.InputLocator,TestDataVariables.InputData,TestDataVariables.Action);

        }
    }
}