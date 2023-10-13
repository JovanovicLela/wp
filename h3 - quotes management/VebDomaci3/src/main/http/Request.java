package main.http;

import lombok.Data;

import java.util.HashMap;

@Data
public class Request {

    private final HttpMethod httpMethod;
    private final String path;
    private HashMap<String, String> elementsForm = null;

    public Request(HttpMethod httpMethod, String path, HashMap<String, String> elementsForm) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.elementsForm = elementsForm;
    }

}
