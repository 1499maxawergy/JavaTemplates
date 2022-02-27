package com.company.abstra;

public class Client {
    private final GameOne gameOne;
    private final GameTwo gameTwo;

    public Client(GamingFactory factory){
        gameOne = factory.createGameOne();
        gameTwo = factory.createGameTwo();
    }

    public void publish(){
        gameOne.print();
        gameTwo.print();
    }
}
