package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyLogger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class XMLDeserialization implements Strategy {

    ArrayList<SerializableObject> objList = new ArrayList<SerializableObject>();
    public ArrayList<SerializableObject> getObjList() {
        return objList;
    }
    @Override
    public void processInput(SerializableObject sObject) {
     MyLogger.writeMessage("--STRATEGY invoked--", MyLogger.DebugLevel.STRATEGY);
        XmlParser xmlParser = new XmlParser();
        try {
            this.objList = xmlParser.parse();
            //for(int i=0;i<objList.size();i++)
            //  System.out.println("OBJLIST:"+objList.get(i));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | IOException e) {
            e.printStackTrace();
        }

    }
    }

