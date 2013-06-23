package team.lizards.ncpdp.datafile;

import java.io.File;
import java.util.List;
import java.util.Map;

import team.lizards.ncpdp.parser.ExcelParser;
import team.lizards.ncpdp.parser.FileParser;

/**
 * Hello world!
 * 
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    String path = "C:\\Workspace\\Java\\Enterprise\\excelparser\\data.xlsx";    
    FileParser parser = new ExcelParser(new File(path));
    
    try {
      List<Map<Integer, String>> rows = parser.getFields();
      for (Map<Integer, String> row: rows) {
        for (Map.Entry<Integer, String> entry: row.entrySet()) {
          System.out.print(entry.getValue() + " ");
        }
        
        System.out.println("");
      }
    }
    catch (Exception ex) {
      System.out.println("Exception occured: " + ex.getMessage());
    }
  }
}
