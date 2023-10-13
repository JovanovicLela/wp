package com.example.d6.models;

import lombok.Data;

import java.io.Serializable;
@Data
public class Comment implements Serializable {

    private String name, comment;

    public Comment(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }


}
