package com.simon.blog.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    // not int

    private String title;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;
    private String postdate;

    public Post(String title, String content, String postdate) {
        this.title = title;
        this.content = content;
        this.postdate = postdate;
    }
}
