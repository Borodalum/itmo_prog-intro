package md2html;

import java.lang.StringBuilder;
import java.util.Map;
import markup.*;

public class HtmlConverter {
    private final StringBuilder convertedHTML;
    private final Map<String, String> alphabet = Map.of(
            "*", "em", "_", "em", "**", "strong", "__", "strong",
            "--", "s", "`", "code", "~", "mark",
            "<", "&lt;", ">", "&gt;", "&", "&amp;"
    );

    public HtmlConverter() {
        convertedHTML = new StringBuilder();
    }

    public void convertToHTML(StringBuilder currentToken) {
        int startIndex = 0;
        int headerLevel = 0;
        while (currentToken.length() - 1 > startIndex && currentToken.charAt(startIndex) == '#') {
            headerLevel++;
            startIndex++;
        }
        if (currentToken.length() <= startIndex)
            return;
        if (!Character.isWhitespace(currentToken.charAt(startIndex))) {
            startIndex -= headerLevel;
            headerLevel = 0;
        }
        if (headerLevel == 0) {
            convertedHTML.append("<p>");
            parseInternal(currentToken.substring(startIndex));
            convertedHTML.append("</p>").append(System.lineSeparator());
        } else {
            if (Character.isWhitespace(currentToken.charAt(startIndex))) {
                startIndex++;
            }
            String openHeader = "<h" + headerLevel + ">";
            String closeHeader = "</h" + headerLevel + ">" + System.lineSeparator();
            convertedHTML.append(openHeader);
            parseInternal(currentToken.substring(startIndex));
            convertedHTML.append(closeHeader);
        }
    }

    private void parseInternal(String bigToken) {
        int i = 0;
        StringBuilder buffer = new StringBuilder();
        String curToken = "";
        while (i < bigToken.length()) {
            char token = bigToken.charAt(i);
            String temp = "";
            if (token == '*' || token == '_') {
                if (i + 1 < bigToken.length() && bigToken.charAt(i + 1) == token) {
                    temp = Character.toString(token).repeat(2);
                    i++;
                } else {
                    temp = Character.toString(token);
                }
            } else if (token == '-') {
                if (i + 1 < bigToken.length() && bigToken.charAt(i + 1) == token) {
                    temp = Character.toString(token).repeat(2);
                    i++;
                } else {
                    if (curToken.isEmpty()) {
                        convertedHTML.append(token);
                    } else {
                        buffer.append(token);
                    }
                }
            } else if (token == '`') {
                temp = Character.toString(token);
            } else if (token == '~') {
                temp = Character.toString(token);
            } else if (token == '\\') {
                if (i + 1 < bigToken.length()) {
                    if (curToken.isEmpty()) {
                        convertedHTML.append(bigToken.charAt(i + 1));
                    } else {
                        buffer.append(bigToken.charAt(i + 1));
                    }
                    i++;
                }
            } else if ((token == '<' || token == '>' || token == '&') && curToken.isEmpty()){
                convertedHTML.append(alphabet.get(Character.toString(token)));
                i++;
                continue;
            } else if (curToken.isEmpty()) {
                convertedHTML.append(token);
                i++;
                continue;
            } else {
                buffer.append(token);
                i++;
                continue;
            }
            if (!temp.isEmpty()) {
                if (curToken.equals(temp)) {
                    convertedHTML.append("<").append(alphabet.get(curToken)).append(">");
                    parseInternal(buffer.toString());
                    convertedHTML.append("</").append(alphabet.get(curToken)).append(">");
                    curToken = "";
                    buffer.setLength(0);
                } else if (curToken.isEmpty()) {
                    curToken = temp;
                } else {
                    buffer.append(temp);
                }
            }
            i++;
        }
        if (buffer.length() != 0 || !curToken.isEmpty()) {
            convertedHTML.append(curToken);
            parseInternal(buffer.toString());
        }
    }
    public String getConvertedHTML() {
        return convertedHTML.toString();
    }
}
