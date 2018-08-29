package coreEngine;
import Actions.keywordActions;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class automationEngine {
    static Sheet testcasesData;
    static KeywordActionsReflection reflection = new KeywordActionsReflection();

    static keywordActions actions;

    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader("C:\\Flogo\\Project\\Keyword-Driven-Framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());

        for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {
            keywordActions.openBrowser("chrome");
            String keyword = testcasesData.getRow(i).getCell(6).getStringCellValue();
            String data = testcasesData.getRow(i).getCell(5).getStringCellValue();
            String identifier = testcasesData.getRow(i).getCell(4).getStringCellValue();


            reflection.getMethods();
            System.out.println(KeywordActionsReflection.method);
            System.out.println(keyword);
            reflection.performAction(keyword,data);



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