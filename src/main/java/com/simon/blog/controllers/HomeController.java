package com.simon.blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.simon.blog.post.Post;
import com.simon.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PostService postService;

    @GetMapping(value = {"/"})
    public String getHomepage(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/search")
    public String getAllPostsByTitle(@RequestParam String title, Model model) {
        List<Post> posts = new ArrayList<>();
        posts = postService.getAllPostsByContent(title);
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/new")
    public String createNewPost() {
        return "posts/newpost";
    }

    @PostMapping("/post/new")
    public String addPost(@RequestParam String title
            , @RequestParam String content, Model model) {

        Post post = new Post(title, content, new Date().toString());
        postService.addPost(post);

        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/posts/{id}")
    public String getUpdatedPost(@PathVariable Integer id,
                                 @RequestParam(required = false) String action,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String content,
                                 Model model) {
        if (action.equals("update")) {
            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            postService.updatePost(id, post);
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);
            return "index";
        }else if(action.equals("edit")){
            Optional<Post> postOptional = postService.getPost(id);
            Post post = postOptional.get();
            model.addAttribute("post", post);
            return "posts/updatedPost";
        }else {
            return "posts/updatedPost";
        }

    }

    @GetMapping("/posts/{id}")
    public String updatePost(@PathVariable Integer id,
                             @RequestParam(required = false) String action,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) String content,
                             Model model) {
        if(action.equals("view")) {
            Optional<Post> postOptional = postService.getPost(id);
            Post post = postOptional.get();
            model.addAttribute("posts", post);
            return "posts/viewpost";

        }else if (action.equals("delete")) {
            postService.deletePost(id);
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);
            return "index";

        }else {
            return "index";
        }
    }

//    @PostMapping("/login")
//    public String getUser (@RequestParam String username,
//                                   @RequestParam String password,
//                                   HttpSession session,
//                                   Model model) {
//        if(username.equals("sam")&&password.equals("sam")){
//            session.setAttribute("user", "sam");
//            return "index";
//        }else {
//            return "user/login";
//        }
//
//    }


}
