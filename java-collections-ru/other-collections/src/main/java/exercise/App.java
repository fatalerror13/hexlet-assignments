package exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            boolean m1HasKey = map1.containsKey(key);
            boolean m2HasKey = map2.containsKey(key);
            Object m1 = map1.getOrDefault(key, null);
            Object m2 = map2.getOrDefault(key, null);

            if (m1HasKey && m2HasKey && m1.equals(m2)) {
                map.put(key, "unchanged");
            } else if (m1HasKey && m2HasKey && !m1.equals(m2)) {
                map.put(key, "changed");
            } else if (!m1HasKey && m2HasKey) {
                map.put(key, "added");
            } else if (m1HasKey && !m2HasKey) {
                map.put(key, "deleted");
            }
        }

        return map;
    }
}
//END
