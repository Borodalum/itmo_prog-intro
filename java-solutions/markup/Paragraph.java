package markup;
import java.util.List;

public class Paragraph implements Markup { 
    private final List<Markup> elements;
    public Paragraph(List<Markup> elements) {
        this.elements = elements;
    }
    
    public void toMarkdown(StringBuilder sb) {
        for (Markup element : elements) {
            element.toMarkdown(sb);
        }
    }
    public void toHtml(StringBuilder sb) {
        for (Markup element : elements) {
            element.toHtml(sb);
        }
    }
}