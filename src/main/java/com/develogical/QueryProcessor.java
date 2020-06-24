package com.develogical;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }//
        else if (query.toLowerCase().contains("what colour is a banana")) {
            return "yellow";
        }
        else if (query.toLowerCase().contains("what is your name")) {
            return "Artem";
        }//"what is 1 plus 12"
        else if (query.toLowerCase().contains("what is ") && query.toLowerCase().contains(" plus ") ) {
            String[] res = query.toLowerCase().replace("what is ", "").split(" plus ");
            if(res.length == 0) return "";

            return String.valueOf(Integer.valueOf(res[0].trim()) + Integer.valueOf(res[1].trim()));
        }//which of the following numbers is the largest:
        else if (query.toLowerCase().contains("which of the following numbers is the largest: ")) {
            String[] res = query.toLowerCase().replace("which of the following numbers is the largest: ", "").split(",");
            if(res.length == 0) return "";

            Integer[] arr = new Integer[res.length];
            for(int i=0;i<res.length;i++){
                arr[i] = Integer.valueOf(res[i].trim());
            }
            Arrays.sort(arr);

            return String.valueOf(arr[arr.length-1]);
        }// what is 9 multiplied by 11
        else if (query.toLowerCase().contains("what is ") && query.toLowerCase().contains(" multiplied by ") ) {
            String[] res = query.toLowerCase().replace("what is ", "").split(" multiplied by ");
            if(res.length == 0) return "";

            return String.valueOf(Integer.valueOf(res[0].trim()) * Integer.valueOf(res[1].trim()));
        }


        return "";
    }
}
