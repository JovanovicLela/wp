package main.app;

import main.http.Request;
import main.http.response.HtmlResponse;
import main.http.response.RedirectResponse;
import main.http.response.Response;

public class QuoteController extends Controller{

    public QuoteController(Request request) {
        super(request);
    }

    @Override
    public Response doGet() {
        Quote quote = QuoteOfTheDay.getInstance().getQuoteOfTheDay();
        StringBuilder html = new StringBuilder();
        html.append("<html>\n<head>\n<title>\nServer response\n</title>\n</head>\n");
        html.append("<body>\n");
        html.append("<form action=\"/save-quote\" method=\"post\">\n" +
                "  <label for=\"author\">Author:</label>\n" +
                "  <input name=\"author\" id=\"author\" type=\"text\"><br><br>\n" +
                "  <label for=\"quote\">Quote: </label>\n" +
                "  <input name=\"quote\" id=\"quote\" type=\"text\"><br><br>\n" +
                "  <button type=\"submit\">Save Quote</button>\n</form>\n" +

                "<h2>Quote of the day:</h2>\n" +
                "<p><b>" + quote.getAuthor() + "</b>: \"" + quote.getText() + "\"</p>\n\n" +
                "<h2>Saved quotes:</h2>\n");

        for (Quote q: QuoteRepository.getInstance().getAllQuotes()) {
            html.append("<p><b>" + q.getAuthor() + "</b>: \"" + q.getText() + "\"</p>\n");
        }

        html.append("</body>\n</html>");

        return new HtmlResponse(html.toString());
    }

    @Override
    public Response doPost() {

        QuoteRepository.getInstance().addQuote(getRequest().getElementsForm().get("author"),
                                               getRequest().getElementsForm().get("quote"));

        return new RedirectResponse("/quotes");
    }
}
