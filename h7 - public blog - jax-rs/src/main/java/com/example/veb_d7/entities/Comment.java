package com.example.veb_d7.entities;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class Comment {

    @NotNull(message = "Author name field is required")
    @NotEmpty(message = "Author name field is required")
    private String author;

    @NotNull(message = "Comment content field is required")
    @NotEmpty(message = "Comment content field is required")
    private String content;

    private Integer commentID;

    public Comment() {
    }

    public Comment(String author, String content, Integer commentID) {
        this.author = author;
        this.content = content;
        this.commentID = commentID;
    }

    public Comment(String author, String content) {
        this.author = author;
        this.content = content;
    }
}
