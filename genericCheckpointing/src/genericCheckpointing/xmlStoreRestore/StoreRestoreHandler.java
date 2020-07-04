package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StoreRestoreHandler implements InvocationHandler {
    ArrayList<SerializableObject> objList = new ArrayList<SerializableObject>();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("readObj")){
            if(args[0].equals("XML")){
//                XmlParser xmlParser = new XmlParser();
//                try {
//                    this.objList = xmlParser.parse();
//                    //for(int i=0;i<objList.size();i++)
//                    //  System.out.println("OBJLIST:"+objList.get(i));
//                } catch (ClassNotFoundException | NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
                XMLDeserialization sStrategy = new XMLDeserialization();
                serializeData(null, sStrategy);
                return sStrategy.getObjList();
            }
        }
        else if(method.getName().equals("writeObj")){
            if(args[1].equals("XML")) {
                serializeData((SerializableObject) args[0], new XMLSerialization());
//                XmlMerger xmlMerger = new XmlMerger();
//                xmlMerger.merge(args[0]);
            }
        }
        //System.out.println(method.getName());
        //System.out.println(args[0]);
        return null;
    }
    public void serializeData(SerializableObject sObject, Strategy sStrategy) {
        sStrategy.processInput(sObject);
    }
}
