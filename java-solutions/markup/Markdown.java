package markup;
import java.util.List;

public abstract class Markdown implements Markup {
    private List<Markup> elements;
    private String markdownTag;
    private String htmlTag;

    public Markdown(List<Markup> elemList, String mdTag, String htmlTag) {
        this.elements = elemList;
        this.markdownTag = mdTag;
        this.htmlTag = htmlTag;
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(markdownTag);
        for (Markup element : elements) {
            element.toMarkdown(sb);
        }
        sb.append(markdownTag);
    }
    public void toHtml(StringBuilder sb) {
        String beginning = "<" + htmlTag + ">";
        String ending = "</" + htmlTag + ">";
        sb.append(beginning);
        for (Markup element : elements) {
            element.toHtml(sb);
        }
        sb.append(ending);
    }
}
