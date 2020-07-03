package com.simon.blog.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository
        extends CrudRepository<Post, Integer > {

        List<Post> findByTitleContainingOrderById(String title);
        List<Post> findByDetailsContainingOrderById(String content);
        List<Post> findByTitleOrDetailsContainingOrderById(String content,String content2);
        List<Post> findByDetailsOrTitleContaining(String content,String content2);
}
