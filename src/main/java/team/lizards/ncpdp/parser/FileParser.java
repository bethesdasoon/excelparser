package team.lizards.ncpdp.parser;

import java.io.File;

public abstract class FileParser {
  @SuppressWarnings("unused")
  private File file;
  
  public FileParser() {
    this.file = null;
  }
  
  public FileParser(File file) {
    setFile(file);
  }
  
  public void setFile(File file) {
    this.file = file;
  }
  
  public abstract void parse();
}
