package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DigitCounter {

    private static int start;
    private static int end;
    private static List<String> nums;
    private static HashMap<String, Integer> results;

    public static void main( String[] args ) {

        if (args.length != 3) {
            System.out.println("Input Error: Must supply a starting number, an ending number, and one or more comma delimited digits to look up.");
            System.exit(1);
        }

        try {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);

            String[] inputNums = args[2].split(",");
            nums = Arrays.asList(inputNums);
            results = new HashMap<>();
            for (String num: nums) {
                results.put(num, 0);
            }

        } catch (NumberFormatException e) {
            System.out.println("Input Error: Inputs must be numbers."); 
            System.exit(1);
        }

        

        for (int i = start; i <= end; i++) {
            char[] digitArr = Integer.toString(i).toCharArray();
            for (char digit : digitArr) {
                String digitStr = Character.toString(digit);
                if (nums.contains(digitStr)) {
                    results.put(digitStr, results.get(digitStr) + 1);
                }
            }
        }


        for (Map.Entry<String, Integer> result : results.entrySet()) {
            System.out.println(result.getKey() + " occurs " + result.getValue() + " times.");
        }
        System.exit(0);
    }
}
