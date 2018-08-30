package DataMapper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static DataMapper.ConfigBuilder.TestCases;

public class TestCaseRowIndexes {
    static List rowValueList = new ArrayList();

    static Map<String, List> testCaseRows = new HashMap<String, List>();
    static Sheet testcasesData;
    static ExcelReader reader = new ExcelReader();
    static int i = 0;
    static int currentKey,currentTestCaseValue;
    public static void main(String args[]) throws IOException, InvalidFormatException {
        //setRowIndexes(){
        ConfigBuilder.configReader();
        System.out.println(ConfigBuilder.TestCasesPath);
        testcasesData = reader.TestCaseReader(ConfigBuilder.TestCasesPath);

        System.out.println(ConfigBuilder.TestCases.size());
        while(i<ConfigBuilder.TestCases.size()) {
            for(int j=1;j<=ExcelReader.sheet.getLastRowNum();j++) {

                if(testcasesData.getRow(j) == null){
                    //System.out.println("im in if");
                    continue;
                }

                else{
                    currentKey = Integer.parseInt(TestCases.get(i).toString());
                    currentTestCaseValue = (int) Double.parseDouble(ExcelReader.sheet.getRow(j).getCell(0).toString());
                    //System.out.println(currentTestCaseValue);
                    //System.out.println(ExcelReader.sheet.getRow(j).getCell(1));
                    //System.out.println((ExcelReader.sheet.getRow(j).getCell(0).getNumericCellValue()));
                    //System.out.println(TestCases.get(i));

                    if (currentTestCaseValue == currentKey){
                        //System.out.println("im in else");
                        System.out.println(ExcelReader.sheet.getRow(j).getCell(1).toString());
                        rowValueList.add(ExcelReader.sheet.getRow(j).getCell(0).getRowIndex());
                        testCaseRows.put((TestCases.get(i).toString()),rowValueList);
                    }
                }

            }

            i++;

        }
        System.out.println(testCaseRows);
    }
}