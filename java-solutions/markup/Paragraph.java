package markup;
import java.util.List;

public class Paragraph extends Markdown { 
    public Paragraph(List<Markdown> elements) {
        this.elements = elements;
    }
    @Override
    public void toMarkdown(StringBuilder sb) {
        for (Markdown element : elements) {
            element.toMarkdown(sb);
        }
    }
    @Override
    public void toHtml(StringBuilder sb) {
        for (Markdown element : elements) {
            element.toHtml(sb);
        }
    }
}