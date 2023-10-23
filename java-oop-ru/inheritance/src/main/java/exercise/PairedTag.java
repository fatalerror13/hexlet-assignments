package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN

// END
public class PairedTag extends Tag {

    private String text = "";
    private final List<Tag> children;

    public PairedTag(String tag, Map<String, String> attributes, String text, List<Tag> children) {
        super(tag, attributes);
        this.text = text;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(printOpenTag());
        sb.append(text);

        for (Tag tag: children) {
            sb.append(tag.printOpenTag());
        }

        sb.append(printCloseTag());

        return sb.toString();
    }

    private String printCloseTag() {
        return "</" + tag + ">";
    }
}