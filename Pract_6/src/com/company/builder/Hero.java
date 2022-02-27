package com.company.builder;

public class Hero {
    private String name;
    private String version;

    public void buildHero(String name){
        this.name = name;
    }

    public void setVersion(String version){
        this.version = version;
    }

    public void print(){
        System.out.println(name + " on " + version);
    }
}
