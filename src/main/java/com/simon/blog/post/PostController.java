package com.simon.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping(value = "/posts/search/{content}")
    public List<Post> getAllPostsBySearch(@PathVariable String content) {
        return postService.getAllPostsByTitle(content);
    }

    @RequestMapping(value = "/posts/{id}")
    public Optional<Post> getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
//    public void deletePost(@PathVariable Integer id) {
//        System.out.println("delete----");
//        postService.deletePost(id);
//    }

    @RequestMapping(value="/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable Integer id, @RequestBody Post post) {

        postService.updatePost(id, post);

    }
}
