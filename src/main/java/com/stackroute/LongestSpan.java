package com.stackroute;

import java.util.*;

public class LongestSpan {

    //Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
        //Use Scanner to get input from console
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        String out = LongestSpan.findLongestSpan(numbers);
        if (out == "-1") {
            System.out.println("Empty Array");
        } else {
            System.out.println(out);
        }


    }

    public static String findLongestSpan(int[] numbers) {
        Map<Integer, String> spannum = new HashMap<Integer, String>();
        List<Integer> spanlist = new ArrayList<Integer>();
        String regex = ":";
        int pos = 0;
        int span = 0;
        String spanstring = "";
        int key = 0;
        int i = 0;
        int j = 0;
        if (numbers.length == 0 || numbers == null) {
            return "-1";
        }
        //adding number and its span

        for (i = 0; i < numbers.length; i++) {
            key = numbers[i];
            if (spannum.containsKey(key)) {
                String y = spannum.get(key);

                String[] splitstring = y.split(",");
                pos = Integer.parseInt(splitstring[0]);
                //System.out.println(pos);
                span = Integer.parseInt(splitstring[1]);
                // System.out.println(span);

                span = (i - pos) + 1;
                spanstring = pos + "," + span;
                spannum.put(key, spanstring);


            } else {
                spanstring = i + "," + 1;
                spannum.put(key, spanstring);
            }

        }
        //  System.out.println(spannum);
        int mapmax = 0;
        int value = 0;
        // add max key in list
        for (int Key : spannum.keySet()) {
            String mapvalue = spannum.get(Key);
            value = Integer.parseInt(mapvalue.split(",")[1]);
            // System.out.println(value);
            if (value > mapmax) {
                mapmax = value;
                spanlist.clear();
                spanlist.add(Key);

            } else if (value == mapmax) {
                spanlist.add(Key);
            }

        }
        //System.out.println(spanlist);
        int val = 0;
        int MAX = 0;
        // find max key from list
        for (int g = 0; g < spanlist.size(); g++) {
            val = spanlist.get(g);
            if (val > MAX) {
                MAX = val;
            }
        }
        //System.out.println(MAX);

        int out = 0;
        out = Integer.parseInt(spannum.get(MAX).split(",")[1]);
        return (MAX + ":" + out);


    }
}
