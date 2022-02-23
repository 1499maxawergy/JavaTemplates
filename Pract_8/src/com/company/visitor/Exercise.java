package com.company.visitor;

abstract class Exercise {
    public abstract void accept(VisitorInterface visitorInterface);
    public abstract void doSomething();
}

