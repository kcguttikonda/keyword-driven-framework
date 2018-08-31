package DataMapper;

import jdk.internal.util.xml.impl.Input;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataVariables {


    public static int TestCaseID;
    public static int TestStepNumber;
    public static String TestCaseTitle;
    public static String Description;
    public static String Identifier;
    public static String InputLocator;
    public static String InputData;
    public static String Action;
    public static List TestCasesUnderTest;
    public static Map testDataVariableList = new HashMap();


    public void setVariables(Sheet testDataSheet, int rowId) {

        try{
            TestCaseID = (int) testDataSheet.getRow(rowId).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
            TestStepNumber = (int) testDataSheet.getRow(rowId).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
            TestCaseTitle = testDataSheet.getRow(rowId).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Description = testDataSheet.getRow(rowId).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Identifier = testDataSheet.getRow(rowId).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            InputLocator = testDataSheet.getRow(rowId).getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            InputData = testDataSheet.getRow(rowId).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Action = testDataSheet.getRow(rowId).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

        }

        catch (Exception e){
            System.out.println("unable to setvaribales "+e.getMessage());
        }

        System.out.println(TestCaseID);
        System.out.println(TestStepNumber);
        System.out.println(TestCaseTitle);
        System.out.println(Description);
        System.out.println(Identifier);
        System.out.println(InputLocator);
        System.out.println(InputData);
        System.out.println(Action);


    }

}


