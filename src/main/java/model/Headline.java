package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public record Headline(String source, String title, String describe, String date,
                       String link) implements Comparable<Headline> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MMM HH:mm", Locale.ENGLISH);

    @Override
    public String toString() {
        return this.title() + "\n" + this.link() + "\n" + this.describe() + "\n" +
                this.source() + " - " + this.date();
    }

    @Override
    public int compareTo(Headline o) {
        try {
            Date date1 = DATE_FORMAT.parse(o.date());
            Date date2 = DATE_FORMAT.parse(this.date());
            return date2.compareTo(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

