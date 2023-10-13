package com.example.veb_d7.entities;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class Post {

    @NotNull(message = "Author name field is required")
    @NotEmpty(message = "Author name field is required")
    private String author;

    @NotNull(message = "Title field is required")
    @NotEmpty(message = "Title field is required")
    private String title;

    @NotNull(message = "Title field is required")
    @NotEmpty(message = "Title field is required")
    private String content;

    private Integer postID;
    private Date postDate;
    private List<Comment> comments;

    public Post() {
    }

    public Post(String author, String title, String content, Integer postID, Date postDate) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.postID = postID;
        this.postDate = new Date();
        comments = new CopyOnWriteArrayList<>();
    }

    public Post(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
