package com.company.abstra;

public class GamingFactoryValve implements GamingFactory{

    @Override
    public GameOne createGameOne() {
        return new GameOneByValve();
    }

    @Override
    public GameTwo createGameTwo() {
        return new GameTwoByValve();
    }
}
