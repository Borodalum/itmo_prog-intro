import java.util.*;
import java.io.*;

import java.util.Arrays;

class IntListPosition {
    private int[] intList = new int[1];
    public int capacity = 0;

    public IntListPosition(int firstValue) {
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
        intList[valueIndex] = newValue;
    }
    public int getValue(int valueIndex) {
        return intList[valueIndex];
    }
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        intList = Arrays.copyOf(intList, capacity);
        outputString.append(intList[0]);
        outputString.append(" ");
        for (int i = 1; i < capacity; i++) {
            outputString.append(intList[i]);
            if (i % 2 != 0) {
                outputString.append(":");
            }
            if (i != capacity - 1 && i % 2 == 0) {
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

public class WsppPosition {
    public static void main(String[] args) {
        Map <String, IntListPosition> wordStat = new LinkedHashMap <String, IntListPosition>();
        try {
            BetterScanner mainReader = new BetterScanner(new File(args[0]));
            try {
                int lineCount = 1;
                while (mainReader.hasNextLine()) {
                    String lineReader = mainReader.nextLine();
                    int wordCount = 0;
                    int wordEndPos = 0;
                    int wordStartPos = 0;
                    String curWord = "";
                    lineReader = lineReader.toLowerCase();
                    for (int i = 0; i < lineReader.length(); i++) {
                        if (Character.isLetter(lineReader.charAt(i))
                        || Character.DASH_PUNCTUATION == Character.getType(lineReader.charAt(i))
                        || lineReader.charAt(i) == '\'') {
                            wordEndPos++;
                        } else {
                            if (wordEndPos != wordStartPos) { 
                                curWord = lineReader.substring(wordStartPos, wordEndPos).trim();
                                wordCount++;
                                IntListPosition valueKey = wordStat.getOrDefault(curWord, new IntListPosition(0));
                                valueKey.append(lineCount);
                                valueKey.append(wordCount);
                                valueKey.changeValue(0, valueKey.getValue(0) + 1);
                                wordStat.put(curWord, valueKey);
                            }
                            wordEndPos = i + 1;
                            wordStartPos = i + 1;
                        }
                    }
                    if (wordEndPos != wordStartPos) { 
                        curWord = lineReader.substring(wordStartPos, wordEndPos).trim();
                        wordCount++;
                        IntListPosition valueKey = wordStat.getOrDefault(curWord, new IntListPosition(0));
                        valueKey.append(lineCount);
                        valueKey.append(wordCount);
                        valueKey.changeValue(0, valueKey.getValue(0) + 1);
                        wordStat.put(curWord, valueKey);
                    }
                    lineCount++;
                }
            } finally {
                mainReader.close();
            }
        } catch (IOException e) {
            System.out.println("Очень жаль, вы проиграли. " + e.getMessage());
        } finally { 
            try { 
                BufferedWriter mainWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(args[1]),
                    "UTF-8"
                ));
                try { 
                    for (Map.Entry entry : wordStat.entrySet()) {
                        mainWriter.write(entry.getKey() + " " + entry.getValue().toString());
                        mainWriter.newLine();
                    } 
                } finally {
                    mainWriter.close();
                }
            } catch (IOException e) { 
                System.out.println("Очень жаль, вы проиграли. " + e.getMessage());
            }
        }
    }
}