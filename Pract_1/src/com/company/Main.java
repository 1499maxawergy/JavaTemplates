package com.company;


import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Function;

public class Main {

    public static int valuate(Integer[] a){
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(a));
        String sum = "";

        for (Integer integer : treeSet) {
            sum += integer;
        }

        return Integer.parseInt(sum);
    }


    public static void main(String[] args) {
        Function<Integer[], Integer> min = d -> valuate(d);
        Integer[] array = {9,2,5,2};
        System.out.println(min.apply(array));
    }
}
