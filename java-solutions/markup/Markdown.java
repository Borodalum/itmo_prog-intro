package markup;
import java.util.List;

public class Markdown {
    protected List<Markdown> elements;
    private String openTag;
    private String closeTag;
    private String openTagHTML;
    private String closeTagHTML;

    public Markdown() {}

    protected void setupTags(String openTag, String closeTag) {
        this.openTag = openTag;
        this.closeTag = closeTag;
    }
    protected void setupHTMLTags(String openTagHTML, String closeTagHTML) {
        this.openTagHTML = openTagHTML;
        this.closeTagHTML = closeTagHTML;
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(openTag);
        for (Markdown element : elements) {
            element.toMarkdown(sb);
        }
        sb.append(closeTag);
    }
    public void toHtml(StringBuilder sb) {
        sb.append(openTagHTML);
        for (Markdown element : elements) {
            element.toHtml(sb);
        }
        sb.append(closeTagHTML);
    }
}
