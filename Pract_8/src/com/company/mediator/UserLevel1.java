package com.company.mediator;

public class UserLevel1 extends User{
    public UserLevel1(MediatorInterface mediator, String name){
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.nickname + "(отправил): " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.nickname + "(получил): " + msg);
    }
}
