# Avandy News
[![Open Source? No!](https://badgen.net/badge/Open%20Source%20%3F/No%21/blue?icon=github)](https://github.com/Naereen/badges/)
[![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://GitHub.com/Naereen/ama)

RSS news search engine of popular news sources with powerful screening of unnecessary information.

A feature of the program is a convenient, automatic news search for several keywords with the search results sent to e-mail.

For the application to work on a PC, Java must be installed: https://www.java.com/ru/download/

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

