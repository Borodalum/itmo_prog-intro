package markup;

import java.util.List;

public class Strikeout extends Markdown{
    private String openTag = "~";
    private String closeTag = "~";
    public Strikeout(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
    }

}
