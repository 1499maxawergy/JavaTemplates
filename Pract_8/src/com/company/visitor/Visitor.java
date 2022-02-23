package com.company.visitor;

public class Visitor implements VisitorInterface{
    @Override
    public void visit(Sleep sleep) {
        sleep.doSomething();
    }

    @Override
    public void visit(Eat eat) {
        eat.doSomething();
    }
}
