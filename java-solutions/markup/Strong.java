package markup;
import java.util.List;

public class Strong extends Markdown{
    private String openTag = "__";
    private String closeTag = "__";
    private String openTagHTML = "<strong>";
    private String closeTagHTML = "</strong>";
    public Strong(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
        super.setupHTMLTags(this.openTagHTML, this.closeTagHTML);
    }
}
