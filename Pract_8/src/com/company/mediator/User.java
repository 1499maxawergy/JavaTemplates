package com.company.mediator;

public abstract class User {
    protected MediatorInterface mediator;
    protected String nickname;

    public User(MediatorInterface mediator, String nickname){
        this.mediator = mediator;
        this.nickname = nickname;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}
