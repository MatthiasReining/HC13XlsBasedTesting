package de.herbstcampus.hcxlsbasedtesting;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void testMultiply() throws IOException {
        Double actual = new App().multiply(2.0, 2.0);
        
        Assert.assertEquals(new Double(4.0), actual);
        
        InputStream xlsFile = AppTest.class.getResourceAsStream("/test-cases.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(xlsFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> rowIterator =sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            
            List<Object> resultRow = new ArrayList<>();
            
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Double value = new Double(cell.getNumericCellValue());
                resultRow.add(value);
            }
            
            Double in1 = (Double) resultRow.get(0);
            Double in2 = (Double) resultRow.get(1);
            Double actual2 = new App().multiply(in1, in2);
            Double expected = (Double) resultRow.get(2);
            
            Assert.assertEquals(expected, actual2);
            
        }
    }
    
}
