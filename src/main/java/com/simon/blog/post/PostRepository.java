package com.simon.blog.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository
        extends CrudRepository<Post, Integer > {

        List<Post> findByTitleContainingOrderById(String title);
        List<Post> findByContentContainingOrderById(String content);
        List<Post> findByTitleOrContentContainingOrderById(String content,String content2);
        List<Post> findByContentOrTitleContaining(String content,String content2);
}
