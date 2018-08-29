package DataMapper;

import jdk.internal.util.xml.impl.Input;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.Map;

public class TestDataVariables {

    private static String OS;
    public static int TestCaseID;
    public static int TestStepNumber;
    public static String TestCaseTitle;
    public static String Description;
    public static String Identifier;
    public static String InputLocator;
    public static String InputData;
    public static String Action;
    public static String Browser;
    public static Map testDataVariableList = new HashMap();

    public void getVariables(Sheet testDataSheet,int rowId){
        for(int i=0;i<testDataSheet.getRow(rowId).getLastCellNum();i++){

            int currentCellIndex = i;
            if(!(testDataSheet.getRow(rowId).getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().isEmpty())){
                //System.out.println(testDataSheet.getRow(rowId).getCell(i).toString());
                testDataVariableList.put(i,testDataSheet.getRow(rowId).getCell(i).toString());
            }
            else{
                System.out.println("NullValueFound-Skipping Value");
            }
        }
        //System.out.println(testDataVariableList);
    }


    public void setVariables(Sheet testDataSheet, int rowId) {
            TestCaseID = (int) testDataSheet.getRow(rowId).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
            TestStepNumber = (int) testDataSheet.getRow(rowId).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
            TestCaseTitle = testDataSheet.getRow(rowId).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Description = testDataSheet.getRow(rowId).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Identifier = testDataSheet.getRow(rowId).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            InputLocator = testDataSheet.getRow(rowId).getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            InputData = testDataSheet.getRow(rowId).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Action = testDataSheet.getRow(rowId).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            Browser = testDataSheet.getRow(rowId).getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
            OS = testDataSheet.getRow(rowId).getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

            System.out.println(TestCaseID);
            System.out.println(TestStepNumber);
            System.out.println(TestCaseTitle);
            System.out.println(Description);
            System.out.println(Identifier);
            System.out.println(InputLocator);
            System.out.println(InputData);
            System.out.println(Action);
            System.out.println(Browser);
            System.out.println(OS);

        }

        }


