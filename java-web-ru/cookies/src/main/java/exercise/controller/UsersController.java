package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import java.util.Collection;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void create(Context ctx) {
        try {
            var firstName = ctx.formParamAsClass("firstName", String.class)
                    .check(v -> !v.isEmpty(), "firstName is empty")
                    .get();
            var lastName = ctx.formParamAsClass("lastName", String.class)
                    .check(v -> !v.isEmpty(), "lastName is empty")
                    .get();
            var email = ctx.formParamAsClass("email", String.class)
                    .check(v -> !v.isEmpty(), "email is empty")
                    .get();
            var password = ctx.formParamAsClass("password", String.class)
                    .check(v -> !v.isEmpty(), "password is empty")
                    .get();
            var token = Security.generateToken();

            var user = new User(firstName, lastName, email, password, token);
            UserRepository.save(user);
            Long id = UserRepository.find(firstName).get().getId();
            ctx.cookie("token", token);
            ctx.redirect(NamedRoutes.userPath(id));
        } catch (ValidationException e) {
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");
            ctx.render("users/build.jte");
        }
    }

    public static void show(Context ctx) {
        String token = ctx.cookie("token");
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (token != null && token.equals(user.getToken())) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
}
