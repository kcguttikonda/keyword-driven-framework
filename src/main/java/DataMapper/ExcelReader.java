package DataMapper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.*;
@Test
public class ExcelReader {
    static Sheet sheet;

    public Sheet TestCaseReader(String path) throws IOException, InvalidFormatException {
        //open a file
        File dataFile = new File(path);
        //File dataFile = new File("C:\\Users\\kguttiko\\Documents\\GitHub\\keyword-driven-framework\\src\\main\\resources\\TestData\\TestCases.xlsx");

        //Feed the opened file to FileInputStream
        FileInputStream inputStream = new FileInputStream(dataFile);

        //Feed the input Stream to buffered stream
        BufferedInputStream bufferStream = new BufferedInputStream(inputStream);

        //create a workbook out of buffered stream
        Workbook workbook = WorkbookFactory.create(bufferStream);
        //GetSheet
        sheet = workbook.getSheet("TestCases");
        System.out.println(sheet.getLastRowNum());
        return sheet;

    }

}
