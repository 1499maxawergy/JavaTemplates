package ru.test;

import org.springframework.stereotype.Component;

@Component
public class WeakKnight implements IKnight{

    @Override
    public String getKnight() {
        return "I am weak knight :(";
    }
}

