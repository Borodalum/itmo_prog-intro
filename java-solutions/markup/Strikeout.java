package markup;
import java.util.List;

public class Strikeout extends Markdown{
    public Strikeout(List<Markup> elements) {
        super(elements, "~", "s");
    }

}
