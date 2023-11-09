package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    public static void loginForm(Context ctx) {
        LoginPage page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void login(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");
        String passwordHash = Security.encrypt(password);

        User user = UsersRepository.findByName(name);

        if (user != null && user.getPassword().equals(passwordHash)) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            LoginPage page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void root(Context ctx) {
        String name = ctx.sessionAttribute("currentUser");
        MainPage page = new MainPage(name);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
}
