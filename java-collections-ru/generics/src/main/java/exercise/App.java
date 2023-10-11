package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(
            List<Map<String, String>> books,
            Map<String, String> where
    ) {
        List<Map<String, String>> result = new ArrayList<>();

        for (var book: books) {
            int sameEntriesCount = 0;

            for (Map.Entry<String, String> entry: where.entrySet()) {
                if (book.containsKey(entry.getKey()) && book.containsValue(entry.getValue())) {
                    sameEntriesCount += 1;
                }
            }

            if (sameEntriesCount == where.size()) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
