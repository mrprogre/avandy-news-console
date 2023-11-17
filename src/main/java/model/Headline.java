package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Headline implements Comparable<Headline> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MMM HH:mm", Locale.ENGLISH);

    private final String source;
    private final String title;
    private final String describe;
    private final String date;
    private final String link;

    public Headline(String source, String title, String describe, String date, String link) {
        this.source = source;
        this.title = title;
        this.describe = describe;
        this.date = date;
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getDescribe() {
        return describe;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return this.getTitle() + "\n" + this.getLink() + "\n" + this.getDescribe() + "\n" +
                this.getSource() + " - " + this.getDate();
    }

    @Override
    public int compareTo(Headline o) {
        try {
            Date date1 = DATE_FORMAT.parse(o.getDate());
            Date date2 = DATE_FORMAT.parse(this.getDate());
            return date2.compareTo(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

