package com.develogical;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class QueryProcessor {

    public boolean isPrime(Integer num){
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }//which city is the Eiffel tower in
        else if (query.toLowerCase().contains("which city is the Eiffel tower in")) {
            return "Paris";
        }
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
            String[] res = query.toLowerCase().split("which of the following numbers is the largest: ")[1].split(",");
            if(res.length == 0) return "";

            Integer[] arr = new Integer[res.length];
            for(int i=0;i<res.length;i++){
                arr[i] = Integer.valueOf(res[i].trim());
            }
            Arrays.sort(arr);

            return String.valueOf(arr[arr.length-1]);
        }// what is 9 multiplied by 11
        else if (query.toLowerCase().contains("what is ") && query.toLowerCase().contains(" multiplied by ") ) {
            String[] res = query.toLowerCase().split("what is ")[1].split(" multiplied by ");
            if(res.length == 0) return "";

            return String.valueOf(Integer.valueOf(res[0].trim()) * Integer.valueOf(res[1].trim()));
        }//8fb83930: which of the following numbers are primes: 112, 491
        else if (query.toLowerCase().contains("which of the following numbers are primes: ")) {
            String[] res = query.toLowerCase().split("which of the following numbers are primes: ")[1].split(",");
            if(res.length == 0) return "";

            Integer[] arr = new Integer[res.length];
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<res.length;i++){
                Integer val = Integer.valueOf(res[i].trim());
                if(isPrime(val)) {
                    sb.append(res[i].trim());
                    sb.append(',');
                }
            }

            if(sb.length() > 0) sb.delete(sb.length() -1, sb.length());

            return "";
        }// what is 9 multiplied by 11

        return "";
    }
}
