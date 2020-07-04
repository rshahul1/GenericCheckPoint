package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.driver.Driver;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class XmlMerger {
    public void merge(Object arg) throws IllegalAccessException {
        SerializableObject objList = (SerializableObject) arg;

        Driver.entireOutput.add("<DPSerialization>");
            String clsName = objList.getClass().getName();
            Class cls = objList.getClass();
            Driver.entireOutput.add("<complexType xsi:type=\""+clsName+"\">");
            Field[] field=cls.getDeclaredFields();
            for(int i=0;i<field.length;i++){
                Class fieldClass = field[i].getType();
                String fieldName = field[i].getName();
                Object fieldObject = field[i].get(objList);
                if(fieldClass.toString().contains("String")){
                    String type= "String";
                    Driver.entireOutput.add("<"+fieldName+" xsi:type=\"xsd:"+type+"\">"+fieldObject+"</"+fieldName+">");
                  }
                else {
                    Driver.entireOutput.add("<" + fieldName + " xsi:type=\"xsd:" + fieldClass + "\">" + fieldObject + "</" + fieldName + ">");
                }
            }
            Driver.entireOutput.add("</complexType>");
            Driver.entireOutput.add("</DPSerialization>");


    }
}

