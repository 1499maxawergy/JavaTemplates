package ru.test;

import org.springframework.stereotype.Component;

@Component
public class KingOfKnights implements IKnight{

    @Override
    public String getKnight() {
        return "I am king of knights!";
    }
}

