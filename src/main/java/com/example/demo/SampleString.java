package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SampleString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        System.out.print(isAnagaram(a,b));

    }

    private static String isAnagaram(String a, String b) {
        if(a.length()!= b.length()){
            return "Not Anagrams";
        }
        char left[]= a.toCharArray();
        char right[]= b.toCharArray();

        Map<String,Integer> leftMap = new HashMap<>();
        Map<String,Integer> rightMap = new HashMap<>();

        int leftCount =0;
        int rightCount =0;
        for(int i=0;i<a.length();i++){
            if(leftMap.containsKey(left[i])){
                int j = leftMap.get(left[i])+1;
                leftMap.put(String.valueOf(left[i]), j);
                leftCount = leftCount+j;
            }
            else{
                leftMap.put(String.valueOf(left[i]),1);
                leftCount =leftCount+1;

            }
            if(rightMap.containsKey(right[i])){
                int j = rightMap.get(right[i])+1;
                rightMap.put(String.valueOf(right[i]), j);
                rightCount = rightCount+j;
            }
            else{
                rightMap.put(String.valueOf(right[i]),1);
                rightCount = rightCount+1;
            }
        }

        if(rightCount==leftCount){
            return "Anagrams";
        }



        return "Anagrams";
    }
}
