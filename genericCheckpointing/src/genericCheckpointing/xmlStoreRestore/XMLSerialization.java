package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyLogger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class XMLSerialization implements Strategy {
    
    //ArrayList<SerializableObject> objList = new ArrayList<SerializableObject>();
    @Override
    public void processInput(SerializableObject sObject) {
      MyLogger.writeMessage("--Strategy invoked--", MyLogger.DebugLevel.STRATEGY);

        XmlMerger xmlMerger = new XmlMerger();
        try {
            xmlMerger.merge(sObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
