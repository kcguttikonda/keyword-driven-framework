package coreEngine;
import Actions.keywordActions;
import DataMapper.TestDataVariables;
import DataMapper.ExcelReader;
import DataMapper.TestDataVariables;
import org.apache.commons.lang.ObjectUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
    static Cell testCaseIDCheck;

    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader("C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());

        for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {
            if(testcasesData.getRow(i)==null){
                continue;
            }

            testdata.setVariables(testcasesData,i);
            reflection.getMethods();
            reflection.performAction(TestDataVariables.Identifier, TestDataVariables.InputLocator, TestDataVariables.InputData, TestDataVariables.Action);

        }
    }
}