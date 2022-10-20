package markup;
import java.util.List;

public class Strikeout extends Markdown{
    private String openTag = "~";
    private String closeTag = "~";
    private String openTagHTML = "<s>";
    private String closeTagHTML = "</s>";
    public Strikeout(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
        // duplicate of tags
        super.setupHTMLTags(this.openTagHTML, this.closeTagHTML);
    }

}
