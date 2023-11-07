package exercise;

import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.NewArticlePage;
import exercise.model.Article;
import exercise.repository.ArticleRepository;
import io.javalin.Javalin;
import io.javalin.validation.ValidationException;

import java.util.Collections;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/articles/new", ctx -> {
            var page = new NewArticlePage("", "", null);

            ctx.render("articles/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/articles", ctx -> {
            try {
                String title = ctx.formParamAsClass("title", String.class)
                        .check(t -> t.length() > 1, "Название не должно быть короче двух символов")
                        .check(t -> !ArticleRepository.existsByTitle(t), "Статья с таким названием уже существует")
                        .get();
                String content = ctx.formParamAsClass("content", String.class)
                        .check(c -> c.length() > 9, "Статья должна быть не короче 10 символов")
                        .get();
                Article article = new Article(title, content);
                ArticleRepository.save(article);

                ctx.redirect("/articles");
            } catch (ValidationException e) {
                String title = ctx.formParamAsClass("title", String.class).getOrDefault("");
                String content = ctx.formParamAsClass("content", String.class).getOrDefault("");
                var page = new NewArticlePage(title, content, e.getErrors());

                ctx.render("articles/build.jte", Collections.singletonMap("page", page)).status(422);
            }

        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
