package com.company.adapter;

public class CardToUsbAdapter implements USB{
    private MemoryCard memoryCard;

    CardToUsbAdapter(MemoryCard memoryCard){
        this.memoryCard = memoryCard;
    }
    @Override
    public void connect() {
        this.memoryCard.insert();
        this.memoryCard.exec();
    }
}
