package search;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


public class Parser {

    public SyndFeed parseFeed(String url) throws IllegalArgumentException, FeedException, IOException {
        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setConnectTimeout(1000);
        XmlReader reader = new XmlReader(urlConnection);

        return new SyndFeedInput().build(reader);
    }
}