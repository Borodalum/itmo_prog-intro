package markup;

import java.util.List;

public class Strong extends Markdown{
    private String openTag = "__";
    private String closeTag = "__";
    public Strong(List<Markdown> elements) {
        this.elements = elements;
        super.setupTags(this.openTag, this.closeTag);
    }
}
