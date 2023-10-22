package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int number) {
        return list.stream()
                .sorted(Home::compareTo)
                .distinct()
                .limit(number)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}
// END
