package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.xmlStoreRestore.XmlParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Driver {

    public static String outFile;
    public static ArrayList<String> entireOutput=new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        if ((args.length != 4) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")||args[2].equals("${arg3}")){

            System.err.println("Error: Incorrect number of arguments. Program requires 4 arguments.");
            System.exit(0);
        }
        if(!args[0].toString().equals("deserser")){
          System.err.println("incorrect mode");
           System.exit(0);
        }
        
        int debugValue = Integer.parseInt(args[3]);   //Storing Debug value
        MyLogger.setDebugValue(debugValue);
        if(debugValue < 0 || debugValue > 2) {
            MyLogger.Message("WARNING!! The assigned debug value is out of range. Check README for the value usage!");
            System.exit(0);
        }
        // FIXME: read the value of checkpointFile from the command line

        FileProcessor fp=new FileProcessor();
        XmlParser.inputFileName = args[1];
        outFile=args[2];
        //fp.readLine(args[0]);
//        XmlParser xmlParser = new XmlParser();
//        xmlParser.setInputFileName(args[0]);
//        try {
//            xmlParser.parse();
//        } catch (ClassNotFoundException | NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        ProxyCreator pc = new ProxyCreator();

        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                new Class[]{
                        StoreI.class, RestoreI.class
                },
                new StoreRestoreHandler()
        );

        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file


        MyAllTypesFirst myFirst = null;
        MyAllTypesSecond mySecond;
        MySpecialTypes mySpecialT = null;


        //SerializableObject myRecordRet;

        ArrayList<SerializableObject> objList = new ArrayList<SerializableObject>();

        // read in a loop till the end of file is indicated
        objList = ((RestoreI) cpointRef).readObj("XML");
        // FIXME: store myRecordRet in a data structure




        // NUM_OF_OBJECTS is the size of the data strucutre in which the objects have been saved
        for (int i=0; i<objList.size(); i++) {

            // use "instance of" to determine which of these methods should be called
            // use this method for MyAllTypesFirst and MyAllTypesSecond.
            if(objList.get(i) instanceof MyAllTypesFirst)
            ((StoreI) cpointRef).writeObj((MyAllTypesFirst) objList.get(i),  "XML");
            else if(objList.get(i) instanceof MyAllTypesSecond)
            ((StoreI) cpointRef).writeObj((MyAllTypesSecond) objList.get(i),  "XML");
            // use this method for MySpecialTypes
            else if(objList.get(i) instanceof MySpecialTypes)
                ((StoreI) cpointRef).writeObj((MySpecialTypes) objList.get(i), "XML");
        }


        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

        Results rs=new Results();
        rs.writeToFile();
    }

    }


