package com.company;

public class Main {

    public static void main(String[] args){
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 3);
        System.out.println(map.get(2));
        MyList<Integer> list = new MyList<>();
        list.add(2);
        list.add(3);
        System.out.println(list.get(1));
    }
}
