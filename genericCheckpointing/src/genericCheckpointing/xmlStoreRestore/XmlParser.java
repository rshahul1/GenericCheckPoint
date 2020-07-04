
package genericCheckpointing.xmlStoreRestore;

//import com.sun.xml.internal.ws.util.StringUtils;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Signature;
import java.util.ArrayList;

public class XmlParser{
    String className;
    FileProcessor fileProcessor = new FileProcessor();

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }



    public static String inputFileName;

    public ArrayList<SerializableObject> parse() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BufferedReader bufferedReader = fileProcessor.readLine(inputFileName);
        String line;
        ArrayList<SerializableObject> objList = new ArrayList<SerializableObject>();
        Class cls = null;
        Class[] signature = new Class[1];
        Object obj = null;
        Object[] param1 = new Object[1];
        while( (line = bufferedReader.readLine())!=null) {

            if (line.contains("<DPSerialization")){}
            else if (line.contains("<complexType")) {
                className = line.substring(line.indexOf('"') + 1, line.indexOf('>') - 1);
                     cls = Class.forName(className);
                     obj = cls.newInstance();
            }
            else if (line.contains("int")) {
                signature[0]=int.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]=Integer.parseInt(value);
                Object result = method.invoke(obj,param1);
            }
            else if (line.contains("long")){
                signature[0]=long.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]=Long.parseLong(value);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("string")){
                signature[0]=String.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= value;
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("boolean")){
                signature[0]=boolean.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= Boolean.parseBoolean(value);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("double")){
                signature[0]=double.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= Double.parseDouble(value);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("float")){
                signature[0]=float.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= Float.parseFloat(value);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("short")){
                signature[0]=short.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= Short.parseShort(value);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("char")){
                signature[0]=char.class;
                String methodName= line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
                methodName ="set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
                String value = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                Method method = cls.getMethod(methodName,signature);
                param1[0]= value.charAt(0);
                Object result = method.invoke(obj,param1);
            }
            else if(line.contains("</DPSerialization>")){
              objList.add((SerializableObject) obj);
            }
        }
        return objList;
    }
}
