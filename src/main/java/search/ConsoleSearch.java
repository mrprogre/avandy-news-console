package search;

import com.sun.syndication.feed.synd.SyndEntry;
import email.EmailManager;
import exception.IncorrectEmail;
import model.TableRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleSearch {
    private final Map<String, String> sources = new HashMap<>();
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MMM HH:mm", Locale.ENGLISH);
    private final List<String> headlinesList = new ArrayList<>();
    private int minutesIntervalConsole;

    private void initRssSources() {
        sources.put("Mail.ru", "https://news.mail.ru/rss/90/");
        sources.put("Lenta", "https://lenta.ru/rss");
        sources.put("Вести", "https://www.vesti.ru/vesti.rss");
        sources.put("Life", "https://life.ru/xml/feed.xml?hashtag=%D0%BD%D0%BE%D0%B2%D0%BE%D1%81%D1%82%D0%B8");
        sources.put("РБК", "http://static.feed.rbc.ru/rbc/logical/footer/news.rss");
        sources.put("Наука и жизнь", "https://www.nkj.ru/rss/");
        sources.put("C-Main", "https://cnews.ru/inc/rss/news.xml");
        sources.put("Коммерсант", "https://www.kommersant.ru/RSS/news.xml");
        sources.put("Forbes", "https://www.forbes.ru/newrss.xml");
        sources.put("МФД", "https://mfd.ru/rss/news/handler.ashx");
        sources.put("Финмаркет", "http://www.finmarket.ru/rss/mainnews.asp");
        sources.put("Habr", "https://habr.com/ru/rss/articles/?fl=ru&limit=100");
    }

    /**
      java -jar ./news.jar from@mail.ru from_password to@mail.ru 160 world russia fifa
      main arguments for console search:
      args1 = email from
      args2 = email from pwd
      args3 = email to
      args4 = interval in minutes
      args5 = keyword1, keyword2 ... argsN = search keywords
    */
    public void searchByConsole(String[] args) {
        String sendEmail = args[0];
        String emailPwd = args[1];
        String sendTo = args[2];
        if (!sendTo.contains("@")) {
            throw new IncorrectEmail("> incorrect e-mail");
        }
        minutesIntervalConsole = Integer.parseInt(args[3]);
        headlinesList.clear();
        int newsCount = 0;

        try {
            System.out.println("> start");
            initRssSources();

            for (Map.Entry<String, String> source : sources.entrySet()) {
                try {
                    for (Object message : new Parser().parseFeed(source.getValue()).getEntries()) {
                        SyndEntry entry = (SyndEntry) message;
                        String title = entry.getTitle();
                        Date pubDate = entry.getPublishedDate();
                        String newsDescribe = entry.getDescription().getValue()
                                .trim()
                                .replaceAll(("<p>|</p>|<br />"), "");

                        TableRow tableRow = new TableRow(
                                source.getKey(),
                                title,
                                newsDescribe,
                                DATE_FORMAT.format(pubDate),
                                entry.getLink());

                        for (String arg : args) {
                            if (arg.equals(args[0]) || arg.equals(args[1]) || arg.equals(args[2]) || arg.equals(args[3]))
                                continue;

                            if (tableRow.getTitle().toLowerCase().contains(arg.toLowerCase())
                                    && tableRow.getTitle().length() > 15) {

                                int dateDiff = compareDatesOnly(new Date(), pubDate);
                                if (dateDiff != 0) {
                                    // Подготовка данных для отправки результатов на почту
                                    String headline = tableRow.getTitle() + "\n" +
                                            tableRow.getLink() + "\n" +
                                            tableRow.getDescribe() + "\n" +
                                            tableRow.getSource() + " - " +
                                            tableRow.getDate();

                                    if (!headlinesList.contains(headline)) {
                                        newsCount++;
                                        headlinesList.add(headline);
                                        System.out.println(newsCount + ") " + tableRow.getTitle());
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception ignored) {
                }
            }

            // auto send results to email
            if (headlinesList.size() > 0) {
                // add headline order numbers
                for (int i = 0; i < headlinesList.size(); i++){
                    headlinesList.set(i, i + 1 + ") " + headlinesList.get(i));
                }

                System.out.println("> sending an email..");
                //System.out.println(headlinesList);
                //new EmailManager().sendMessage(headlinesList, sendEmail, emailPwd, sendTo);
            } else {
                System.out.println("> news headlines not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Сравнение дат для отображения новостей по интервалу
    private int compareDatesOnly(Date now, Date in) {
        int minutes = minutesIntervalConsole;

        Calendar minus = Calendar.getInstance();
        minus.setTime(new Date());
        minus.add(Calendar.MINUTE, -minutes);
        Calendar now_cal = Calendar.getInstance();
        now_cal.setTime(now);

        if (in.after(minus.getTime()) && in.before(now_cal.getTime())) {
            return 1;
        } else
            return 0;
    }
}
