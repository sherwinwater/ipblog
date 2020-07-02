package com.simon.blog.controllers;

import com.simon.blog.location.Location;
import com.simon.blog.location.LocationService;
import com.simon.blog.post.Post;
import com.simon.blog.post.PostRepository;
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

    @GetMapping("/includes/header")
    public String getHeader() {
        return "includes/header";
    }

    @GetMapping("/includes/footer")
    public String getFooter() {
        return "includes/footer";
    }

    @GetMapping("/includes/content")
    public String getContent() {
        return "includes/content";
    }

    @GetMapping("/includes/aside")
    public String getAside() {
        return "includes/asideright";
    }

    @GetMapping("/posts/new")
    public String createNewPost() {
        return "posts/new";
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
