package team.lizards.ncpdp.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public abstract class FileParser {
  private File file;

  public FileParser() {
    setFile(null);
  }

  public FileParser(File file) {
    setFile(file);
  }

  public void setFile(File file) {
    this.file = file;
  }

  public File getFile() throws FileNotFoundException {
    if (file == null) {
      throw new FileNotFoundException("Missing file. Pass the file " +
          "using setFile method before parsing.");
    }
    
    return file;
  }

  public abstract Map<Integer, String> getFieldNames() throws Exception;

  public abstract void getFields() throws Exception;
}
