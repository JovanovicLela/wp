package com.example.d6.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Post implements Serializable {

    private String author, title, content;
    private Date postdate;
    private int id;
    private List<Comment> comments;

    public Post(String author, String title, String content, int id, List<Comment> comments) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.id = id;
        this.comments = comments;
        this.postdate = new Date();
    }
}
