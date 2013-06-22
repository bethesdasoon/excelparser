package team.lizards.ncpdp.datafile;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser {
  private String filepath;

  public ExcelParser(String filepath) {
    this.filepath = filepath;
  }

  public void parse() {
    try {
      Workbook workbook = WorkbookFactory.create(new File(filepath));
      Sheet sheet = workbook.getSheetAt(0);
      
      Iterator<Row> rowIt = sheet.rowIterator();
      while (rowIt.hasNext()) {
        Row row = rowIt.next();
        
        Iterator<Cell> cellIt = row.cellIterator();
        while (cellIt.hasNext()) {
          Cell cell = cellIt.next();
          System.out.print(cell.getStringCellValue() + " | ");
        }
        
        System.out.println("");
        break;
      }
    }
    catch (Exception ex) {
      System.out.println("Exception occured: " + ex.getMessage());
    }
  }
}
