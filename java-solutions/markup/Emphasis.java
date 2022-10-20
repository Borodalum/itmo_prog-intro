package markup;
import java.util.List;

public class Emphasis extends Markdown{
    private String openTag = "*";
    private String closeTag = "*";
    private String openTagHTML = "<em>";
    private String closeTagHTML = "</em>";

    public Emphasis(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
        super.setupHTMLTags(this.openTagHTML, this.closeTagHTML);
    }
}
