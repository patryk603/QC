package DDT;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ReadExcelData {

    public static void main(String[] args){

        ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\Data.xlsx");

        System.out.println(excel.getData(0, 1, 0));

    }
}
