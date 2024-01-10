package com.example.demo.Controller;

import com.example.demo.Payload.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    @Autowired

    private PostService postService;
@PostMapping("/{post}")
    public ResponseEntity<Post> savepost(@RequestBody Post post ){
        Post newpost = postService.savepost(post);
        return new ResponseEntity<>(newpost, HttpStatus.CREATED);
    }

@GetMapping("/{postId}")
    public Post getpostbyId(@PathVariable () String postId)
{
    Post getpostbyid = postService.getpostbyid(postId);

    return getpostbyid;
}
    @GetMapping("/{postId}/comments")


public ResponseEntity<PostDto>getthepostwithcomment(@PathVariable String postId){
    PostDto postDto=postService.getthepostwithcomment(postId);
    return new ResponseEntity<>(postDto,HttpStatus.OK);

}

}
