package DDT;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {

    public static void main(String[] args) throws Exception {

        File src = new File("C:\\Users\\30001236\\IdeaProjects\\LOTests\\testData\\Data.xlsx");

        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet1 = wb.getSheetAt(0);

        //String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();

        int rowcount = sheet1.getLastRowNum();

        rowcount = rowcount + 1;

        System.out.println("Total rows is "+rowcount);

        for(int i=0;i<=rowcount;i++){

            String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
            System.out.println("Data from Row"+i+" is "+data0);
        }

    }
}
