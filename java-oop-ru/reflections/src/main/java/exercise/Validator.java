package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(final Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();

        try {
            for (Field field: fields) {
                NotNull notNull = field.getAnnotation(NotNull.class);

                field.setAccessible(true);
                var value = field.get(address);

                if (notNull != null && value == null) {
                    result.add(field.getName());
                }

            }
        } catch (IllegalAccessException e) {

        }

        return result;
    }
}
// END
