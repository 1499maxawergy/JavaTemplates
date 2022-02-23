package com.company.mediator;

import java.util.ArrayList;
import java.util.List;

public class UserMediator implements MediatorInterface{
    private List<User> users;

    public UserMediator(){
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User i: this.users){
            if (i != user){
                i.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
