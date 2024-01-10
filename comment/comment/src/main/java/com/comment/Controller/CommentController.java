package com.comment.Controller;

import com.comment.Entity.Comment;
import com.comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    //Http://localhost:8082/api/comments
    @PostMapping
    public ResponseEntity <Comment> savecomment(@RequestBody Comment comment){

        Comment c = commentService.savecomment(comment);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public List<Comment> getallcommentbypostid(@PathVariable String postId){


        List<Comment> commentList=commentService.getallcommentbypostid(postId);
        return commentList;
    }
}

