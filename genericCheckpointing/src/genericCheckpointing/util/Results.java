package genericCheckpointing.util;

import genericCheckpointing.driver.Driver;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Results {
    public void writeToFile() {

        try {
            String joinOutput = " ";
            FileWriter f = new FileWriter(Driver.outFile);
            for (int i = 0; i < Driver.entireOutput.size(); i++) {
                joinOutput = joinOutput + Driver.entireOutput.get(i);
                joinOutput = joinOutput + "\n";
            }
            f.write(joinOutput);
            f.close();
            MyLogger.writeMessage("Output.txt is generated", MyLogger.DebugLevel.FILE_GENERATE);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
