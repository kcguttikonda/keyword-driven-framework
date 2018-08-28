package coreEngine;
import Actions.keywordActions;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;


import java.io.IOException;

public class automationEngine {
    static Sheet testcasesData;

    @Test
    public static void Engine() throws IOException, InvalidFormatException, InterruptedException {

        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader("C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());
        for (int i = 1; i <= testcasesData.getLastRowNum(); i++) {
            String action = testcasesData.getRow(i).getCell(6).getStringCellValue();
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
            }

        }
    }
}