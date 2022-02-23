package com.company.visitor;


public class Main {

    public static void main(String[] args) {
        Eat eat = new Eat();
        Sleep sleep = new Sleep();
        eat.accept(new Visitor());
        sleep.accept(new Visitor());
    }
}
