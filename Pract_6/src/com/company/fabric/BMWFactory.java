package com.company.fabric;

public class BMWFactory implements MachineFactory{
    @Override
    public Machine factoryMethod() {
        return new BMW();
    }
}
