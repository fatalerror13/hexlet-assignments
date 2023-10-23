package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private final String text;

    private final TagInterface children;

    public LabelTag(String text, TagInterface children) {
        this.text = text;
        this.children = children;
    }

    @Override
    public String render() {
        return "<label>" + text + children.render() + "</label>";
    }
}
// END
