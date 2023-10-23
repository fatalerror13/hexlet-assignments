package exercise;

import java.util.HashMap;
import java.util.Map;

public class Tag {

    protected String tag;
    protected Map<String, String> attributes = new HashMap<>();

    public Tag(String tag, Map<String, String> attributes) {
        this.attributes = attributes;
        this.tag = tag;
    }

    protected String printOpenTag() {
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        sb.append(tag);
        sb.append(" ");

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(entry.getKey())
                    .append("=\"")
                    .append(entry.getValue())
                    .append("\" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");

        return sb.toString();
    }
}