package com.company.abstra;

public class Main {
    public static void main(String[] args) {
        GamingFactory factory = new GamingFactoryValve();
        Client client = new Client(factory);
        client.publish();

        factory = new GamingFactoryEpic();
        client = new Client(factory);
        client.publish();
    }
}
