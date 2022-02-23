package ru.max;


import org.springframework.stereotype.Component;

@Component
public class Knight {
    private IKnight knight;

    public void fight(){
        System.out.println("Go fight. " + knight.getKnight());
    }

    public void setKnight(IKnight knight) {
        this.knight = knight;
    }
}
