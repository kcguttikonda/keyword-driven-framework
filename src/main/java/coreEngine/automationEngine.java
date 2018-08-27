package coreEngine;
import Actions.keywordActions;
import DataMapper.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;

public class automationEngine {
    static Sheet testcasesData;
    public static void main(String args[]) throws IOException, InvalidFormatException {

        ExcelReader reader = new ExcelReader();

        testcasesData = reader.TestCaseReader("C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        System.out.println(testcasesData.getLastRowNum());
        for(int i=1;i<=testcasesData.getLastRowNum();i++){
            if(testcasesData.getRow(i).getCell(6).getStringCellValue().equals("openurl")){
                keywordActions.openBrowser("chrome");
                String url = String.valueOf(testcasesData.getRow(i).getCell(5));
                keywordActions.openurl(url);

            }
        }



    }
}
