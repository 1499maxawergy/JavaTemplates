package com.company.fabric;

public class MazdaFactory implements MachineFactory{
    @Override
    public Machine factoryMethod() {
        return new Mazda();
    }
}
