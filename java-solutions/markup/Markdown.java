package markup;
import java.util.List;

public class Markdown {
    protected List<Markdown> elements;
    private String openTag;
    private String closeTag;

    public Markdown() {}

    protected void setupTags(String openTag, String closeTag) {
        this.openTag = openTag;
        this.closeTag = closeTag;
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(openTag);
        for (Markdown element : elements) {
            element.toMarkdown(sb);
        }
        sb.append(closeTag);
    }
}
