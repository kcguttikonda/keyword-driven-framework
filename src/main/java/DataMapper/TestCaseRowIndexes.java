package DataMapper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
    static List rowValueList =new ArrayList();

    static Map<String, List> testCaseRows = new HashMap<String, List>();
    static Sheet testcasesData;
    static ExcelReader reader = new ExcelReader();
    public static void main(String args[]) throws IOException, InvalidFormatException {
        //setRowIndexes(){
        ConfigBuilder.configReader();
        System.out.println(ConfigBuilder.TestCasesPath);
        testcasesData = reader.TestCaseReader(ConfigBuilder.TestCasesPath);


        for(int i=1;i<ExcelReader.sheet.getLastRowNum();i++) {
            for(int j=0;j<=ConfigBuilder.TestCases.size();j++){
               //System.out.println("im in 2nd loop");
               //System.out.println(TestCases.get(i));
               //System.out.println(ExcelReader.sheet.getRow(j).getCell(0));
               //System.out.println(ExcelReader.sheet.getRow(j).getCell(1));
               if(testcasesData.getRow(i)==null){
                   System.out.println("im in if");
                   continue;
               }

               else{
                   if (ExcelReader.sheet.getRow(j).getCell(0).toString()==TestCases.get(i)){
                       System.out.println("im in else");
                       rowValueList.add(ExcelReader.sheet.getRow(j).getCell(0).getRowIndex());
                   }
                   }
           }
       }
       System.out.println(testCaseRows);
       System.out.println(rowValueList);
    }
}
