package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;

@Log
public class PostsController {

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).getOrDefault(-1L);
        var post = PostRepository.find(id);

        if (post.isEmpty()) {
            throw new NotFoundResponse("Page not found");
        }

        var page = new PostPage(post.get());

        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        Integer page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        List<Post> allPosts = PostRepository.getEntities();
        int limit = 5;
        int to = page * limit;
        int from = to - limit;
        int pages =  allPosts.size() / limit;
        List<Post> postsToShow = allPosts.subList(from, to);
        boolean hasPrev = page > 1;
        boolean hasNext = page < pages;

        var postsPage = new PostsPage(postsToShow, hasPrev, hasNext, page);

        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    }
}
