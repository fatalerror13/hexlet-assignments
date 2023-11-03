package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {
        List<Map<String, String>> users = Data.getUsers();

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            Integer page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            Integer per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            int to = page * per;
            int from = to - per;

            ctx.json(users.subList(from, to));
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
