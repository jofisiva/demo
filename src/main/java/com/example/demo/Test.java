package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test {



    public static void main(String args[]){
        //int n =9;
      //Integer [] num ={10,20,20,10, 10, 30, 50, 10, 20};

        int n =7;
        Integer [] num ={1,2,1, 2 ,1,3,2};

       List<Integer> arraySort = Arrays.asList(num);
        arraySort.sort(Integer::compareTo);
//1,1,1,2,2,2,3
       HashMap<Integer,Integer> map = new HashMap<>();
       // System.out.print(count);

        for(int i=0;i<n;i++){
           if(map.containsKey(num[i])){
               int count = map.get(num[i])+1;
               map.put(num[i],count);
           }else{
               map.put(num[i],1);
           }



        }
        int pairs = 0;
        for(Integer frequency : map.values()) {
            //System.out.println(frequency);
           // System.out.println(frequency/2);
            pairs += frequency /2;
           // System.out.println(frequency+","+pairs);
        }
        System.out.println(pairs);
     //List<Integer>  result=
           //  map.entrySet().stream().filter(i->i.getValue()>2).
             //.forEach(e->System.out.println(e.getKey()+","+e.getValue()));
    }
}
