package de.ehmka.projects.xls4junit.api;

import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> suc(Integer input) {
        List<Integer> result = new LinkedList<>();
        Integer firstSuc = input + 1;
        Integer secondSuc = input + 2;
        Integer thirdSuc = input + 3;
        result.add(firstSuc);
        result.add(secondSuc);
        result.add(thirdSuc);
        return result;
    }
}
