package com.company.mediator;

public class Main {

    public static void main(String[] args){
        MediatorInterface mediator = new UserMediator();
        MediatorInterface mediatorAdmins = new UserMediator();

        User user_1 = new UserLevel1(mediator, "Sanek");
        User user_2 = new UserLevel1(mediator, "Nikitos");
        User user_3 = new UserLevel1(mediator, "Stas");

        User user_a1 = new UserLevel1(mediatorAdmins, "Pashok");
        User user_a2 = new UserLevel1(mediatorAdmins, "Evgeniy");
        User user_a3 = new UserLevel1(mediatorAdmins, "Gomel");

        mediator.addUser(user_1);
        mediator.addUser(user_2);
        mediator.addUser(user_3);
        mediator.addUser(user_a1);
        mediator.addUser(user_a2);
        mediator.addUser(user_a3);

        mediatorAdmins.addUser(user_a1);
        mediatorAdmins.addUser(user_a2);
        mediatorAdmins.addUser(user_a3);

        user_2.send("Привет, парни! Пойдем работать...");
        user_a3.send("Пусть работают, а мы пойдем отдохнем!");
    }

}
