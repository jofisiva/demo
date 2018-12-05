package com.example.demo;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


/**
 * Hello world!
 *
 */
public class App
{

    public static void main(String[] args) {


       long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        try {
            long actualTotal = customThreadPool.submit(
                    () -> aList.parallelStream().reduce(0L, Long::sum)).get();
            System.out.print(actualTotal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //  assertEquals((lastNum + firstNum) * lastNum / 2, actualTotal);
    }

}

