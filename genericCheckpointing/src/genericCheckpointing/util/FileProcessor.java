package genericCheckpointing.util;

import genericCheckpointing.xmlStoreRestore.XmlParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcessor {
    //XmlParser xmlParser = new XmlParser();
    
    BufferedReader bufferedReader;
    public BufferedReader readLine(String filename) {
     MyLogger.writeMessage("--File Processor invoked--", MyLogger.DebugLevel.FILE_PROCESSOR);
        String line = null;

        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        return bufferedReader;
    }
}
