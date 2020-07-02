package com.simon.blog.controllers;


import com.simon.blog.post.Post;
import com.simon.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String getHomepage(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/new")
    public String createNewPost() {
        return "posts/index";
    }

    @PostMapping("/posts/new")
    public String addPost(@RequestParam String title
            , @RequestParam String content,Model model) {

        Date date = new Date();
        Post post = new Post(title, date.toString(), content);
        postService.addPost(post);

        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

}
