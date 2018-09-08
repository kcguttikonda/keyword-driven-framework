package DataMapper;

import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static DataMapper.ConfigBuilder.TestCases;
public class TestCaseRowIndexes {
    static ExcelReader reader = new ExcelReader();
    static int i = 0;
    static int currentKey,currentTestCaseValue;
    public static Map<String, List> testCaseRows = new HashMap<String, List>();
    public void buildTestCasesList(List TestCases,Sheet testcasesData)  {
        try{
            while(i<TestCases.size()) {
                List rowValueList = new ArrayList();
                for(int j=1;j<=ExcelReader.sheet.getLastRowNum();j++) {
                    //if(testcasesData.getRow(j) == null){
                      if(testcasesData.getRow(j).getCell(0).getCellTypeEnum() == CellType.BLANK){
                        //System.out.println("im in if");
                        continue;
                    }
                    else{
                        currentKey = Integer.parseInt(TestCases.get(i).toString());
                        currentTestCaseValue = (int) Double.parseDouble(ExcelReader.sheet.getRow(j).getCell(0).toString());
                        if (currentTestCaseValue == currentKey){
                            rowValueList.add(ExcelReader.sheet.getRow(j).getCell(0).getRowIndex());
                            testCaseRows.put((TestCases.get(i).toString()),rowValueList);
                        }
                    }
                }i++;
            }
        }
        catch (Exception e){
            System.out.println("unable to get row index"+e.getMessage());
            Assert.fail("Failed to set row indexes");
        }


        System.out.println(testCaseRows);
    }
}