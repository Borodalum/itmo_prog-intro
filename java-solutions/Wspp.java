import java.util.*;
import java.io.*;
import java.net.NetworkInterface;
public class Wspp {
    public static void main(String[] args) {
        Map <String, IntList> wordStat = new LinkedHashMap <String, IntList>();
        try {
            BetterScanner mainReader = new BetterScanner(new File(args[0]));
            try {
                int wordCount = 0;
                while (mainReader.hasNextLine()) {
                    String lineReader = mainReader.nextLine();
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
                                IntList valueKey = wordStat.getOrDefault(curWord, new IntList(0));
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
                        IntList valueKey = wordStat.getOrDefault(curWord, new IntList(0));
                        valueKey.append(wordCount);
                        valueKey.changeValue(0, valueKey.getValue(0) + 1);
                        wordStat.put(curWord, valueKey);
                    }
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