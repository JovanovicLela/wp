package main.app;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuoteRepository {

    private List<Quote> allQuotes;

    private QuoteRepository() {
        allQuotes = new ArrayList<>();
    }

    private static class QuoteRepositoryHolder {
        private static QuoteRepository instance = new QuoteRepository();
    }
    public static QuoteRepository getInstance() {
        return QuoteRepositoryHolder.instance;
    }


    public void addQuote(String author, String text) {
        allQuotes.add(new Quote(author, text));
    }


}
