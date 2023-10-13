package main.app;

import lombok.Data;

@Data
public class Quote {

    private String author, text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
