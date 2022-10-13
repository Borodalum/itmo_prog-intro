import java.io.Reader;
import java.io.StringReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

import java.lang.StringBuilder;

public class BetterScanner {
    private static final int BUFFER_SIZE = 1024;
    
    private final Reader scanInput;
    private char[] charBuffer = new char[BUFFER_SIZE];
    private int curBufferSize = 0;
    private int posInBuffer = 0;
    private boolean hasLine = false;
    private boolean hasNext = false;

    private StringBuilder outputString = new StringBuilder();
    
    public BetterScanner(InputStream inputStream) {
        scanInput = new InputStreamReader(inputStream);
    }
    public BetterScanner(File inputFile) throws IOException {
        scanInput = new InputStreamReader(
            new FileInputStream(inputFile),
            "UTF-8"
        );
    }
    public BetterScanner(String inputString) {
        scanInput = new StringReader(inputString);
    }
    
    private void fillBuffer() {
        try { 
            curBufferSize = scanInput.read(charBuffer);
            posInBuffer = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isLineSeparator(char inChar) {
        if (inChar == '\r' || inChar == '\n' || inChar == '\u0085'
        || inChar == '\u2028' || inChar == '\u2029') {
            return true;
        } else { 
            return false;
        }
    }

    public String nextLine() {
        if (curBufferSize == 0 || posInBuffer == curBufferSize) {
            fillBuffer();
        }
        String outputLine;
        boolean wasLineSep = false;
        if (hasLine == false) {
            outputString.setLength(0);
            while (posInBuffer < curBufferSize) {  
                if (this.isLineSeparator(charBuffer[posInBuffer])) {
                    if (charBuffer[posInBuffer] == '\r') {
                        wasLineSep = true;
                        posInBuffer++;
                    } else if (charBuffer[posInBuffer] == '\n' && wasLineSep) {
                        posInBuffer++;
                        hasLine = true;
                        break;
                    } else {
                        posInBuffer++;
                        hasLine = true;
                        break;
                    }
                } else {
                    if (wasLineSep) {
                        break;
                    }
                    outputString.append(charBuffer[posInBuffer]);   
                    posInBuffer++;
                }
                if (posInBuffer == curBufferSize && curBufferSize == BUFFER_SIZE) {
                    fillBuffer();
                }
            }
            outputLine = outputString.toString();
            if (outputLine.isEmpty() == false) {
                hasLine = true;
            }
        } else { 
            outputLine = outputString.toString();
            hasLine = false;
            outputString.setLength(0);
        }
        return outputLine;
    }
    public boolean hasNextLine() {
        String nextLine = this.nextLine();
        return curBufferSize > 0 || hasLine;
    }
    
    public String next() {
        if (curBufferSize == 0 || posInBuffer == curBufferSize) {
            fillBuffer();
        }
        String outputWord;
        boolean wasWhiteSpace = false;
        if (hasNext == false) {
            outputString.setLength(0);
            while (posInBuffer < curBufferSize) {  
                if (Character.isWhitespace(charBuffer[posInBuffer])) {
                    wasWhiteSpace = true;
                    posInBuffer++;
                } else {
                    if (wasWhiteSpace) {
                        break;
                    }
                    outputString.append(charBuffer[posInBuffer]);   
                    posInBuffer++;
                }
                if (posInBuffer == curBufferSize && curBufferSize == BUFFER_SIZE) {
                    fillBuffer();
                }
            }
            outputWord = outputString.toString();
            if (outputWord.isEmpty() == false) {
                hasNext = true;
            }
        } else { 
            outputWord = outputString.toString();
            hasNext = false;
            outputString.setLength(0);
        }
        return outputWord;
    }
    public boolean hasNext() {
        String next = this.next();
        return curBufferSize > 0 || hasNext;
    }
    
    public int nextInt() {
        if (curBufferSize == 0 || curBufferSize == posInBuffer) {
            fillBuffer();
        }
        return Integer.parseInt(this.next());
    }
    public boolean hasNextInt() {
        try { 
            int checkInt = this.nextInt();
            return true;
        } catch (InputMismatchException e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void close() throws IOException {
        scanInput.close();
    }
}