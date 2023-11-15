package exercise.daytime;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
public class Day implements Daytime {
    private final String name = "day";
}
