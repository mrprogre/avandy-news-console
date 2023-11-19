# Avandy News Console
![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://avandy-news.ru/index-en.html)

RSS news search engine of popular news sources with powerful screening of unnecessary information.

A feature of the program is a convenient, automatic news search for several keywords with the search results sent to e-mail.

For the application to work on a PC, Java must be installed: https://www.java.com/ru/download/

*Example: jar is laid out on a server where Linux is installed and a command is specified in crontab to call the program around the clock. No news will be missed! Here is the command that I indicated (parameter No. 1 - email from, 2 - email from password, 3 - email to, 4 - the interval (the moment of the call minus 1440 minutes (day), then several keywords separated by a space. That is, every day at 10:30 am I receive all the news for the day by the specified words + I keep a log of the program):*

        crontab -e        
        30 10 * * * java -jar ./news.jar from@mail.ru from_password to@mail.ru 1440 мосбирж министр SpaceX >> /home/user/news.log

### In Windows PowerShell
![image](https://github.com/mrprogre/avandy-news-console/assets/45883640/6c3d9445-cadf-417b-9c3f-d6202a86901c)

### Message example
![image](https://github.com/mrprogre/avandy-news-console/assets/45883640/f820142b-486e-411e-879f-975354b60ba0)
