package com.simon.blog.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// JPA
@Service
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);

        return posts;
    }

    public List<Post> getAllPostsByTitle(String title) {
        List<Post> posts = new ArrayList<>();
        postRepository.findByTitleContainingIgnoreCaseOrderById(title)
                .forEach(posts::add);

        return posts;
    }

    public List<Post> getAllPostsByContent(String content) {
        List<Post> posts = new ArrayList<>();
//        postRepository.findByTitleOrContentContainingOrderById(content,content)
//                .forEach(posts::add);

//        postRepository.findByTitleContainingOrderById(content).forEach(posts::add);
//        postRepository.findByContentContainingOrderById(content).forEach(posts::add);
//         postRepository.findByTitleOrContentContainingOrderById(content,content).forEach(posts::add);
//         postRepository.findByContentOrTitleContaining(content,content).forEach(posts::add);
         posts = postRepository.findByContentOrTitleContainingIgnoreCase(content,content);
         for(Post post : posts){
             log.info(post.toString());
         }

        return posts;
    }

    public Optional<Post> getPost(Integer id) {
        return postRepository.findById(id);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post) {
        Post post1 = postRepository.findById(id).get();
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        postRepository.save(post1);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}

//@Service
//public class PostService {
//    User user1 = new User(
//            "u1",
//            "Jany",
//            "Lawrence",
//            new Location("l1", "Boston"),
//            "Jany@gmail.com");
//
//    User user2 = new User(
//            "u2",
//            "Jadon",
//            "Mills",
//            new Location("l2", "Toronto"),
//            "Jadon@gmail.com");
//
//    Post post1 = new Post(
//            "p1",
//            "01-Jan-19",
//            user1,
//            "Its good to love and be loved");
//
//    Post post2 = new Post(
//            "p2",
//            "02-Jan-19",
//            user2,
//            "We all need someone");
//
//    private List<Post> posts =
//            new ArrayList<>(Arrays.asList(post1, post2));
//
//    public List<Post> getAllPosts() {
//        return posts;
//    }
//
//    public Post getPost(String id){
//        Post post = posts.stream()
//                .filter(t -> id.equals(t.getId()))
//                .findFirst()
//                .orElse(null);
//        return post;
//    }
//
//    public void addPost(Post post) {
//        posts.add(post);
//    }
//
//    public void deletePost(String id) {
//        posts.removeIf(p -> p.getId().equals(id));
//    }
//
//    public void updatePost(String id, Post post) {
//        for(int i = 0; i < posts.size(); i++) {
//            Post p = posts.get(i);
//            if(p.equals(post)) {
//                posts.set(i, post);
//            }
//        }
//    }
//}
