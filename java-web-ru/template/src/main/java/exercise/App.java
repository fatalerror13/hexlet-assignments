package exercise;

import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import exercise.model.User;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;
import java.util.List;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var header = "Users List";
            var page = new UsersPage(header, USERS);

            ctx.render(
                    "users/index.jte",
                    Collections.singletonMap("page", page)
            );
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).getOrDefault(-1L);
            var user = USERS.stream()
                    .filter(u -> u.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            var header = "User info";
            var page = new UserPage(header, user);

            ctx.render(
                    "users/show.jte",
                    Collections.singletonMap("page", page)
            );
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
