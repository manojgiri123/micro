package com.example.demo.service;

import com.example.demo.Payload.PostDto;
import com.example.demo.Repository.PostRepository;
import com.example.demo.config.RestTemplateConfig;
import com.example.demo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {


    @Autowired
    private RestTemplateConfig restTemplate;
    @Autowired
    private PostRepository postRepository;
    public Post savepost(Post post){

        Post savepost1 = postRepository.save(post);
        return savepost1;
    }

    public Post getpostbyid(String postId) {
       Post post=postRepository.findById(postId).get();
        return post;
    }

    public PostDto getthepostwithcomment(String postId) {

        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplate.getRestTemplate().getForObject("http://localhost:8081/api/comments/" + postId, ArrayList.class);

        PostDto postDto=new PostDto();
        postDto.setPostId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setComments(comments);

        return postDto;
    }
}
