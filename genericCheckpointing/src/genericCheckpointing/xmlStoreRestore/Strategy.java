package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface Strategy {
    void processInput(SerializableObject sObject);
}
