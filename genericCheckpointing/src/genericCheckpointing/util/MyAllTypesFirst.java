package genericCheckpointing.util;

//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

public class MyAllTypesFirst extends SerializableObject{

    public int myInt;
    public long myLong;
    public String myString;
    public boolean myBool;

    public long getMyOtherLong() {
        return myOtherLong;
    }

    public int myOtherInt;

    public void setMyOtherLong(long myOtherLong) {
        this.myOtherLong = myOtherLong;
    }

    public long myOtherLong;

    public MyAllTypesFirst(){
        this.myInt=0;
        this.myLong=0;
        this.myString=" ";
        this.myBool= Boolean.parseBoolean("False");
        this.myOtherInt=0;
    }
    public int getMyInt(){
        return myInt;
    }
    public void setMyInt(int myInt){
        this.myInt=myInt;
    }
    public long getMyLong(){
        return myLong;
    }
    public void setMyLong(long myLong){
        this.myLong=myLong;
    }
    public String getMyString(){
        return myString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAllTypesFirst that = (MyAllTypesFirst) o;
        return getMyInt() == that.getMyInt() &&
                getMyLong() == that.getMyLong() &&
                getMyBool() == that.getMyBool() &&
                getMyOtherInt() == that.getMyOtherInt() &&
                Objects.equals(getMyString(), that.getMyString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMyInt(), getMyLong(), getMyString(), getMyBool(), getMyOtherInt());
    }

    public void setMyString(String myString){
        this.myString=myString;
    }
    public boolean getMyBool(){
        return myBool;
    }
    public void setMyBool(boolean myBool){
        this.myBool=myBool;
    }
    public int getMyOtherInt(){
        return myOtherInt;
    }
    public void setMyOtherInt(int myOtherInt){
        this.myOtherInt=myOtherInt;
    }

    @Override
    public String toString() {
        return "MyAllTypesFirst{" +
                "myInt=" + myInt +
                ", myLong=" + myLong +
                ", myString='" + myString + '\'' +
                ", myBool=" + myBool +
                ", myOtherInt=" + myOtherInt +
                '}';
    }
}
