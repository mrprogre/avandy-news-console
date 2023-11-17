package search;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.LocalTime;

public class Parser {
    LocalTime timeStart;
    Duration searchTime;
    final static int LONG_SEARCH = 2;

    public SyndFeed parseFeed(String url) throws IllegalArgumentException, FeedException, IOException {
        timeStart = LocalTime.now();
        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setConnectTimeout(100);
        XmlReader reader = new XmlReader(urlConnection);

        // подсчёт времени поиска
        searchTime = Duration.between(timeStart, LocalTime.now());

        String urlToConsole = getNameFromUrl(url);

        if (searchTime.getSeconds() > LONG_SEARCH)
            System.out.println("long search - " + urlToConsole + " - " + searchTime.getSeconds() + " s.");

        return new SyndFeedInput().build(reader);
    }

    private String getNameFromUrl(String url) {
        String urlToConsole = "empty";
        if (url != null) {
            urlToConsole = url.replaceAll(("https://|http://|www."), "").concat("/");
            urlToConsole = urlToConsole.substring(0, urlToConsole.indexOf("/"));
        }
        return urlToConsole;
    }
}