package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ErrorTest {
    @Test
    void negativeRadiusException() {
        NegativeRadiusException error = new NegativeRadiusException("");
        assertThat(error).isInstanceOf(Exception.class);
    }
}
