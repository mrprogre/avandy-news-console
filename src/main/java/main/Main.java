package main;

import utils.Properties;
import search.ConsoleSearch;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Command example: from@mail.ru from_password to@mail.ru 1440 first second thirdKeyword");

        // for tests --> Need to create class "Properties" with String EMAIL_PASSWORD = "password"
        String[] argsTest = {"rps_project@mail.ru", Properties.EMAIL_PASSWORD, "rps_project@mail.ru", "60", "а", "б", "в"}; args = argsTest;

        if (args.length != 0) {
            new ConsoleSearch().searchByConsole(args);
        }
    }

}