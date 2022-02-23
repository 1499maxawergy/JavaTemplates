package com.company.visitor;

public class Eat extends Exercise{
    @Override
    public void accept(VisitorInterface visitorInterface) {
        visitorInterface.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("Кто-то поел");
    }
}
