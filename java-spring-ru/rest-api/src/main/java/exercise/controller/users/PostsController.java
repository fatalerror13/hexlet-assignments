package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

@RestController
@RequestMapping("api/users")
public class PostsController {
    private List<Post> posts = new ArrayList<>(Data.getPosts());

    @GetMapping("/{id}/posts")
    public List<Post> index(
            @PathVariable String id
    ) {
        return posts.stream()
                .filter(p -> p.getUserId() == Integer.parseInt(id))
                .toList();
    }

    @PostMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(
            @PathVariable String id,
            @RequestBody Post data
    ) {
        Post post = new Post();
        post.setBody(data.getBody());
        post.setTitle(data.getTitle());
        post.setSlug(data.getSlug());
        post.setUserId(Integer.parseInt(id));
        posts.add(post);

        return post;
    }
}
