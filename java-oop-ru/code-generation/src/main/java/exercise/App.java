package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN

// END
public class App {
    public static void save(Path path, Car car) {
        try {
            Files.write(path, car.serialize().getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            String content = Files.readString(path);

            return Car.unserialize(content);
        } catch (IOException e) {}

        return null;
    }
}