package markup;

public class Text implements Markup {
    public String text;
    public Text(String text) {
        this.text = text;
    }
    public void toMarkdown(StringBuilder sb) { 
        sb.append(text);
    }
    public void toHtml(StringBuilder sb) { 
        sb.append(text);
    }

}