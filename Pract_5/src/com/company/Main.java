package com.company;

public class Main {



    public static void main(String[] args) {
	    Singleton singleton = new Singleton();
        Singleton2 singleton2 = new Singleton2();
        Singleton3 singleton3 = Singleton3.INSTANCE;
    }
}
