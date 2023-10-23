package exercise;

import java.util.Map;

public class SingleTag extends Tag {

    public SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        return this.printOpenTag();
    }
}