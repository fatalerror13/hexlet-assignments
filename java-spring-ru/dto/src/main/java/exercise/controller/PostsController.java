package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.dto.PostDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.model.Post;
import exercise.repository.CommentRepository;
import exercise.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(p -> {
                    var dto = toPostDTO(p);
                    var comments = commentRepository.findByPostId(p.getId())
                            .stream().map(this::commentDTO).toList();
                    dto.setComments(comments);
                    return dto;
                })
                .toList();

        return result;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var comments = commentRepository.findByPostId(post.getId())
                .stream().map(this::commentDTO).toList();
        var dto = toPostDTO(post);
        dto.setComments(comments);

        return dto;
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        return dto;
    }

    private CommentDTO commentDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }
}
