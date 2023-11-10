package exercise.controller;

import exercise.dto.posts.BuildPostPage;
import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import java.util.Collections;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        String body = ctx.formParam("body");

        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(n -> n.length() >= 2, "Name is too short")
                    .get();

            Post post = new Post(name, body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Пост был успешно создан!");

            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            String name = ctx.formParam("name");
            BuildPostPage page = new BuildPostPage(name, body, e.getErrors());

            ctx.render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void index(Context ctx) {
        PostsPage page = new PostsPage(PostRepository.getEntities());
        page.setFlash(ctx.consumeSessionAttribute("flash"));

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }


    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
