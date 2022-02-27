package com.company.abstra;

public class GamingFactoryEpic implements GamingFactory{
    @Override
    public GameOne createGameOne() {
        return new GameOneByEpic();
    }

    @Override
    public GameTwo createGameTwo() {
        return new GameTwoByEpic();
    }
}
