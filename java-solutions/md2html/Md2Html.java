package md2html;

import java.io.*;

public class Md2Html {
    public static void main(String[] args) {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0]),
                    "UTF-8"
            ));
            BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(args[1]),
                    "UTF-8"
            ));
            StringBuilder token = new StringBuilder();
            HtmlConverter mdParser = new HtmlConverter();
            String currentLine = inputReader.readLine();
            while (currentLine != null) {
                if (currentLine.trim().length() != 0) {
                    token.append(currentLine);
                    currentLine = inputReader.readLine();
                    if (currentLine != null && currentLine.trim().length() != 0)
                        token.append(System.lineSeparator());
                    continue;
                } else {
                    mdParser.convertToHTML(token);
                    token.setLength(0);
                }
                currentLine = inputReader.readLine();
            }
            mdParser.convertToHTML(token);
            outputWriter.write(mdParser.getConvertedHTML());
            outputWriter.close();
            inputReader.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
