package com.simon.blog.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository
        extends CrudRepository<Post, Integer > {

        List<Post> findByTitleContainingIgnoreCaseOrderById(String title);
        List<Post> findByContentContainingOrderById(String content);
        List<Post> findByTitleOrContentContainingOrderById(String content,String content2);
        List<Post> findByContentOrTitleContainingIgnoreCase(String content,String content2);
}
