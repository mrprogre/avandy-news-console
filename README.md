# Avandy News (Jdbc, Swing, SQLite)
[![Open Source? No!](https://badgen.net/badge/Open%20Source%20%3F/No%21/blue?icon=github)](https://github.com/Naereen/badges/)
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://GitHub.com/Naereen/ama)

RSS news search engine of popular news sources with powerful screening of unnecessary information.

A feature of the program is a convenient, automatic news search for several keywords with the search results sent to e-mail.

The current version of the program: https://github.com/mrprogre/news_lite/raw/master/news.jar

For the application to work on a PC, Java must be installed: https://www.java.com/ru/download/

![demo](https://user-images.githubusercontent.com/45883640/208309521-32c3e4f9-252f-486c-9feb-36eb424918ac.gif)

----
**Program features:**
- multi-user application
- manual search for titles by one word (empty field - all news are displayed without excluded news headlines)
- manual search by keywords (at the bottom of the application is keyword search without excluding news headlines)
- search by double-clicking on a word in the top-10 table of the entire news archive for all time
- automatic search every 60 seconds (by setting the checkbox)
- sending the search result to e-mail (+ the ability to choose the automatic sending of results after each search)
- export results to Excel
- double click on the title opens the news webpage
- analysis of the frequency of words in news headlines using the SQLite database (displays everything that is repeated > 2 times)
- displaying the log of the program
- saving interface state
- ability to work in SQLite
- Ability to add a new RSS source. Deactivate existing ones or delete them.
- the ability to exclude words from the word frequency analysis table (right side of the interface)
- you can add words to excluded (top of the interface), and titles containing them will not be displayed
- translation of English titles by right click + Translate
- learning English words (when you press the button, another word is displayed with translation to the console)
- window transparency setting
- saving favorite titles
- quick transition to frequently used sites (map, search engine, etc.)
- event notification. You can add any holiday or other significant date.
- you can copy the database file to any place on your computer and specify the path to it in settings (I do this for synchronization between computers)
- the ability to change 5 shortcut links to sites with the right mouse button
- work with the application in the console is provided:

*Example: jar is laid out on a server where Linux is installed and a command is specified in crontab to call the program around the clock. No news will be missed! Here is the command that I indicated (parameter No. 1 - email from, 2 - email from password, 3 - email to, 4 - the interval (the moment of the call minus 1440 minutes (day), then several keywords separated by a space. That is, every day at 10:30 am I receive all the news for the day by the specified words + I keep a log of the program):*

        crontab -e        
        30 10 * * * java -jar ./news.jar from@mail.ru from_password to@mail.ru 1440 гамак fisu адмирал >> /home/user/news.log

In Windows PowerShell:
![image](https://user-images.githubusercontent.com/45883640/208451653-7d9e19d8-8add-4090-b3c4-bf9ce42984af.png)

----
*Mail settings must be specified in the settings when using the GUI

*Sending is made from postal services: Mail.ru, Gmail, Yandex, Yahoo, Rambler.*

Message example:

![image](https://user-images.githubusercontent.com/45883640/208294666-e3bd4846-e712-4c46-b017-5416a0cd5dc6.png)

Initial path to program files

**Windows**: C:\Users\user\News

**Linux**: home/user/News

