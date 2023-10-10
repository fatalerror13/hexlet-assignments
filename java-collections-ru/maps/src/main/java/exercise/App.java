package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> result = new HashMap<>();

        if (sentence.isEmpty()) {
            return result;
        }

        for (String word : sentence.split(" ")) {
            Integer count = result.getOrDefault(word, 0);
            result.put(word, count + 1);
        }

        return result;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\n");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder
                    .append("  ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }

        builder.append("}");

        return builder.toString();
    }
}
//END
