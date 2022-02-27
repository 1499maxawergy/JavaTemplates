package com.company.builder;

public class PudgeBuilder implements Builder{
    Hero hero = new Hero();
    @Override
    public void buildHero() {
        hero.buildHero("Pudge");
    }

    @Override
    public void setVersion() {
        hero.setVersion("7.30d");
    }

    @Override
    public Hero getHero() {
        return hero;
    }
}
