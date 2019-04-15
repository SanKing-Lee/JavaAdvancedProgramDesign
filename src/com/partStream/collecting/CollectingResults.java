package com.partStream.collecting;

import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Sean
 * Date: Created In 11:22 2019/4/2
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CollectingResults {
    public static void main(String[] args){
        Iterator<Integer> iter = Stream.iterate(0, n->n+1).limit(10)
                .iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        Object[] numbers = Stream.iterate(0, n->n+1).limit(10).toArray();
        System.out.println("Object array: " + numbers);

        try{
            Integer number = (Integer) numbers[0];
            System.out.println("number: " + number);
            System.out.println("The following statement throws an exception");
            Integer[] numbres2 = (Integer[])numbers;
        }
        catch (ClassCastException e){
            System.out.println(e);
        }

        Integer[] numbers3 = Stream.iterate(0, n->n+1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: "+ numbers3);

        IntSummaryStatistics summary = Stream.iterate(0, n->n+1).limit(20)
                .collect(Collectors.summarizingInt(n->n+1));
        double average = summary.getAverage();
        double max = summary.getMax();
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
    }
}
