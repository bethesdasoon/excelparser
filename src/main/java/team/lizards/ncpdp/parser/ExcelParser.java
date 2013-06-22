package team.lizards.ncpdp.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser extends FileParser {
  
  public ExcelParser() {
    super();
  };
  
  public ExcelParser(File file) {
    super(file);
  }
  
  @Override
  public Map<Integer, String> getFieldNames() throws Exception {
    Workbook workbook = WorkbookFactory.create(getFile());
    Sheet sheet = workbook.getSheetAt(0);
    
    System.out.println("First sheet: " + workbook.getSheetAt(0));
    System.out.println("Second sheet: " + workbook.getSheetAt(1));
    
    Map<Integer, String> columns = new HashMap<>();
    Row firstRow = sheet.getRow(sheet.getFirstRowNum());
    
    Iterator<Cell> cellIt = firstRow.cellIterator();
    while(cellIt.hasNext()) {
      Cell cell = cellIt.next();
      columns.put(cell.getColumnIndex(), cell.getStringCellValue());
    }
    
    return columns;
  }
  
  @Override
  public void getFields() 
      throws Exception {  
    Workbook workbook = WorkbookFactory.create(getFile());
    int numSheets = workbook.getNumberOfSheets();
    
    for(int index = 0; index < numSheets; index++) {
      getSheetRows(workbook.getSheetAt(index));
    }
    
    /*Iterator<Row> rowIt = sheet.rowIterator();
    while (rowIt.hasNext()) {
      Row row = rowIt.next();
      
      Iterator<Cell> cellIt = row.cellIterator();
      while (cellIt.hasNext()) {
        Cell cell = cellIt.next();
        System.out.print(cell.getStringCellValue() + " | ");
        cell.getColumnIndex();
      }
      
      System.out.println("");
      break;
    }*/
  }
  
  private List<Map<Integer, String>> getSheetRows(Sheet sheet) {
    List<Map<Integer, String>> rowCollection = new ArrayList<>();
    
    Iterator<Row> rowIt = sheet.rowIterator();
    while (rowIt.hasNext()) {
      Row row = rowIt.next();
      Map<Integer, String> rowValue = new HashMap<>();
      
      Iterator<Cell> cellIt = row.cellIterator();
      while (cellIt.hasNext()) {
        Cell cell = cellIt.next();
        rowValue.put(cell.getColumnIndex(), cell.getStringCellValue());
      }
      
      rowCollection.add(rowValue);
    }
    
    return rowCollection;
  }
}
