package main;

import search.ConsoleSearch;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Command example: from@mail.ru from_password to@mail.ru 1440 first second thirdKeyword");

        // test
        String[] argsTest = {"rps_project@mail.ru", "pwd", "rps_project@mail.ru", "600", "класс", "диет"};
        args = argsTest;

        if (args.length != 0) {
            new ConsoleSearch().searchByConsole(args);
        }
    }

}