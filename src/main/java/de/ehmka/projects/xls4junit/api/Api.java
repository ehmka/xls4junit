package de.ehmka.projects.xls4junit.api;

public class Api {


    public String calculate(String input) {
        return input;
    }

    public String calculateSecond(String input) {
        switch (input) {
            case "2":
                return "4";
            case "4":
                return "8";
            default:
                return "0";
        }
    }
}
