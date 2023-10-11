package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int elements = 2;

        List<Integer> actual = App.take(list, elements);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(actual).isEqualTo(expected);
        // END
    }

    @Test
    void testTake1() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(7, 3, 10));
        int elements = 8;

        List<Integer> actual = App.take(list, elements);
        assertThat(actual).isEqualTo(list);
        // END
    }
}
