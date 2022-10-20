package markup;

public class Text extends Markdown {
    public String text;
    public Text(String text) {
        this.text = text;
    }
    @Override
    public void toMarkdown(StringBuilder sb) { 
        sb.append(text);
    }
}