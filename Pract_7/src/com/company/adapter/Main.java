package com.company.adapter;

public class Main {

    public static void main(String[] args) {
	    MemoryCard memoryCard = new MemoryCard();
        CardToUsbAdapter cTUA = new CardToUsbAdapter(memoryCard);
        cTUA.connect();
    }
}
