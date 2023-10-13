package main.app;

import main.http.Request;
import main.http.response.Response;
import lombok.Data;

@Data
public abstract class Controller {

    protected Request request;

    public Controller(Request request) {
        this.request = request;
    }

    public abstract Response doGet();
    public abstract Response doPost();
}
