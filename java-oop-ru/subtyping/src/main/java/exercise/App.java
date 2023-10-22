package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        Map<String, String> newMap = new HashMap<>();

        for (Entry<String, String> entry: map.toMap().entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }

        for (Entry<String, String> entry: newMap.entrySet()) {
            map.unset(entry.getValue());
        }

        for (Entry<String, String> entry: newMap.entrySet()) {
            map.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
