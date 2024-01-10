package com.comment.Service;

import com.comment.Entity.Comment;
import com.comment.Payload.Post;
import com.comment.Repository.CommentRepository;
import com.comment.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    private CommentRepository commentRepository;

    public Comment savecomment(Comment comment) {

        Post post = restTemplate.getRestTemplate().getForObject("http://localhost:8080/api/posts/" + comment.getPostId(), Post.class);

        if (post != null) {

            Comment savecomment = commentRepository.save(comment);
        } else {
            return null;

        }


        return comment;
    }

    public List<Comment> getallcommentbypostid(String postId) {

        List<Comment> byPostId = commentRepository.findByPostId(postId);
        return byPostId;
    }
}