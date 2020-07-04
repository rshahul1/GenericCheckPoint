package genericCheckpointing.util;

import java.util.Objects;

public class MyAllTypesSecond extends MyAllTypesFirst {
    public double myDoubleT;
    public float myFloatT;
    public short myShortT;
    public char myCharT;

    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }

    public void setMyOtherDoubleT(double myOtherDoubleT) {
        this.myOtherDoubleT = myOtherDoubleT;
    }

    public double myOtherDoubleT;

    public MyAllTypesSecond(){
        this.myDoubleT=0;
        this.myFloatT= (float) 0.0;
        this.myShortT=0;
        this.myCharT=' ';
    }

    public double getMyDoubleT(){
        return myDoubleT;
    }
    public void setMyDoubleT(double myDoubleT){
        this.myDoubleT=myDoubleT;
    }

    @Override
    public String toString() {
        return "MyAllTypesSecond{" +
                "myDoubleT=" + myDoubleT +
                ", myFloatT=" + myFloatT +
                ", myShortT=" + myShortT +
                ", myCharT=" + myCharT +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyAllTypesSecond that = (MyAllTypesSecond) o;
        return Double.compare(that.getMyDoubleT(), getMyDoubleT()) == 0 &&
                Float.compare(that.getMyFloatT(), getMyFloatT()) == 0 &&
                getMyShortT() == that.getMyShortT() &&
                getMyCharT() == that.getMyCharT();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMyDoubleT(), getMyFloatT(), getMyShortT(), getMyCharT());
    }

    public float getMyFloatT(){
        return myFloatT;
    }
    public void setMyFloatT(float myFloatT){
        this.myFloatT=myFloatT;
    }
    public short getMyShortT(){
        return myShortT;
    }
    public void setMyShortT(short myShortT){
        this.myShortT=myShortT;
    }
    public char getMyCharT(){
        return myCharT;
    }
    public void setMyCharT(char myCharT){
        this.myCharT=myCharT;
    }
}
