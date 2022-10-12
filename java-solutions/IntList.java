import java.util.Arrays;

public class IntList {
    private int[] intList = new int[1];
    public int capacity = 0;
    
    public IntList(int firstValue) {
        this.append(firstValue);
    }

    public void append(int inInt) {
        if (capacity >= intList.length) {
            if (intList.length == 0) { 
                intList = Arrays.copyOf(intList, 1);
            } else { 
                intList = Arrays.copyOf(intList, intList.length * 2);
            }
        }
        intList[capacity] = inInt;
        capacity++;
    }
    public void changeValue(int valueIndex, int newValue) {
        try {
            intList[valueIndex] = newValue;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    public int getValue(int valueIndex) {
        return intList[valueIndex];
    }
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        intList = Arrays.copyOf(intList, capacity);
        for (int i = 0; i < capacity; i++) {
            outputString.append(intList[i]);
            if (i != capacity - 1) {
                outputString.append(" ");
            }
        }
        return outputString.toString(); 
    }
    public void setLength(int newLength) {
        intList = Arrays.copyOf(intList, newLength);
        capacity = 0;
    }

}  