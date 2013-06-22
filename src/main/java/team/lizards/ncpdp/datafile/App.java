package team.lizards.ncpdp.datafile;

/**
 * Hello world!
 * 
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    ExcelParser excelParser = new ExcelParser("C:\\Workspace\\" +
    		"Java\\Enterprise\\excelparser\\data.xlsx");
    excelParser.parse();
  }
}
