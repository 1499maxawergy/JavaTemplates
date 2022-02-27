package com.company.builder;

public class SFBuilder implements Builder{
    Hero hero = new Hero();
    @Override
    public void buildHero() {
        hero.buildHero("SF");
    }

    @Override
    public void setVersion() {
        hero.setVersion("7.30e");
    }

    @Override
    public Hero getHero() {
        return hero;
    }
}
