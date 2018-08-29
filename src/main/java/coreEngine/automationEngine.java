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

        testcasesData = reader.TestCaseReader("C:\\Flogo\\Project\\Keyword-Driven-Framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());
        //keywordActions.openBrowser("chrome");
        for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {


            //testdata.getVariables(testcasesData,i);
            testdata.setVariables(testcasesData,i);
            if(i==1){
                keywordActions.openBrowser(TestDataVariables.Browser);
            }
            reflection.getMethods();
            //System.out.println(testcasesData.getRow(1).getCell(1).toString());
            //System.out.println(KeywordActionsReflection.method);
            //System.out.println(TestDataVariables.Action);

            reflection.performAction(TestDataVariables.Identifier,TestDataVariables.InputLocator,TestDataVariables.InputData,TestDataVariables.Action);



           /*
            if (action.equals("openurl")) {
                keywordActions.openBrowser("chrome");
                String url = String.valueOf(testcasesData.getRow(i).getCell(5));
                keywordActions.openurl(url);

            } else if (action.equalsIgnoreCase("click")) {
                String locator = testcasesData.getRow(i).getCell(4).getStringCellValue();
                keywordActions.click(locator);
            } else if (action.equalsIgnoreCase("clearandenter")) {
                String locator = testcasesData.getRow(i).getCell(4).getStringCellValue();
                String input =testcasesData.getRow(i).getCell(5).getStringCellValue();
                keywordActions.clearandenter(locator,input);
            } else if (action.equalsIgnoreCase("closebrowser")) {
                keywordActions.closeBrowser();
            }*/

        }
    }
}