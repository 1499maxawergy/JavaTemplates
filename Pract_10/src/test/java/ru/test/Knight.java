package ru.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Knight {
    private IKnight knight;

    public void fight(){
        System.out.println("Go fight. " + knight.getKnight());
    }

    @Autowired
    @Qualifier("kingOfKings")
    public void setKnight(IKnight knight) {
        this.knight = knight;
    }
}
