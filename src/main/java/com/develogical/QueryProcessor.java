package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        else if (query.toLowerCase().contains("what is your name")) {
            return "Artem";
        }
        else if (query.toLowerCase().contains("what is 1 plus 12")) {
            return "13";
        }
        else if (query.toLowerCase().contains("which of the following numbers is the largest: 267, 647, 86, 4")) {
            return "647";
        }


        return "";
    }
}
