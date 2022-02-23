package ru.max;

import org.springframework.stereotype.Component;

public class StrongKnight implements IKnight{

    @Override
    public String getKnight() {
        return "I am strong knight.";
    }
}

