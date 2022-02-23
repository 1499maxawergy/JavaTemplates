package com.company.visitor;

public class Sleep extends Exercise{
    @Override
    public void accept(VisitorInterface visitorInterface) {
        visitorInterface.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("Кто-то поспал");
    }
}
