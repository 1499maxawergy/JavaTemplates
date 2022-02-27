package com.company.fabric;

public class Main {

    public static void main(String[] args) {
        MachineFactory factory = new BMWFactory(); // factory - BMWFactory, MazdaFactory
        Machine machine = factory.factoryMethod(); // machine - BMW, Mazda
        machine.print();
        factory = new MazdaFactory();
        machine = factory.factoryMethod();
        machine.print();
    }
}
