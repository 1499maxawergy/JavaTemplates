package ru.test;

import org.springframework.stereotype.Component;

@Component
public class StrongKnight implements IKnight{

    @Override
    public String getKnight() {
        return "I am strong knight.";
    }
}

