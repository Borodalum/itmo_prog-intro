package markup;

import java.util.List;

public class Emphasis extends Markdown{
    private String openTag = "*";
    private String closeTag = "*";

    public Emphasis(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
    }
}
