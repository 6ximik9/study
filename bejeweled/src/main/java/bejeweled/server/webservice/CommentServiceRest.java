package bejeweled.server.webservice;

import bejeweled.entity.Comment;
import bejeweled.service.CommentException;
import bejeweled.service.CommentService;
import bejeweled.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentServiceRest {

    private final CommentService commentService;

    public CommentServiceRest(CommentService commentService) {
        this.commentService = commentService;
    }

    //POST -> http://localhost:8080/api/comments
    @PostMapping
    public void addComment(@RequestBody  Comment comment)
    {
       commentService.addComment(comment);
    }

    //GET -> http://localhost:8080/api/comments/bejeweled
    @GetMapping("/{game}")
    public List<Comment> getComments(@PathVariable String game){
        return commentService.getComments(game);
    }
}
