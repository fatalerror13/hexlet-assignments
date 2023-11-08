package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String posts() {
        return "/posts";
    }

    public static String post(Long id) {
        return post(String.valueOf(id));
    }

    public static String post(String id) {
        return posts() + "/" + id;
    }
}
