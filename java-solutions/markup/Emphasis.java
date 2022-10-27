package markup;
import java.util.List;

public class Emphasis extends Markdown{
    public Emphasis(List<Markup> elements) {
        super(elements, "*", "em");
    }
}
