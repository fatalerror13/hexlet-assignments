package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// BEGIN
class App {
    public static String getForwardedVariables(String config) {
        Pattern pattern = Pattern.compile("environment=\\\"([^\\\"]*)");
        Matcher matcher = pattern.matcher(config);
        List<String> strings = new ArrayList<>();
        StringJoiner sb = new StringJoiner(",");

        while (matcher.find()) {
            strings.add(matcher.group(1));
        }

        for (String line : strings) {
            if (line.contains(",")) {
                String[] words = line.split(",");
                for (String word : words) {
                    addWord(word, sb);
                }
            } else {
                addWord(line, sb);
            }
        }

        return sb.toString();
    }

    private static void addWord(String word, StringJoiner stringJoiner) {
        if (word.startsWith("X_FORWARDED")) {
            stringJoiner.add(word.replace("X_FORWARDED_", ""));
        }
    }
}
//END
