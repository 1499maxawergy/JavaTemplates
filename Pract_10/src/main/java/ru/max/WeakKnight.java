package ru.max;

import org.springframework.stereotype.Component;

public class WeakKnight implements IKnight{

    @Override
    public String getKnight() {
        return "I am weak knight :(";
    }
}

