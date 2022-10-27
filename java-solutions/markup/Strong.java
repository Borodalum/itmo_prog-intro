package markup;
import java.util.List;

public class Strong extends Markdown{
    public Strong(List<Markup> elements) {
        super(elements, "__", "strong");
    }
}
