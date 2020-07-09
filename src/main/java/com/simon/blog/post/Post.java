package com.simon.blog.post;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "post")
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

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getPostdate() {
//        return postdate;
//    }
//
//    public void setPostdate(String postdate) {
//        this.postdate = postdate;
//    }
}
