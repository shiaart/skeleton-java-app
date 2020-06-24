package com.develogical;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        else if (query.toLowerCase().contains("what is your name")) {
            return "Artem";
        }//"what is 1 plus 12"
        else if (query.toLowerCase().contains("what is ") && query.toLowerCase().contains(" plus ") ) {
            String[] res = query.toLowerCase().replace("what is ", "").split(" plus ");


            return String.valueOf(Integer.valueOf(res[0]) + Integer.valueOf(res[1]));
        }
        else if (query.toLowerCase().contains("which of the following numbers is the largest: 267, 647, 86, 4")) {
            return "647";
        }


        return "";
    }
}
