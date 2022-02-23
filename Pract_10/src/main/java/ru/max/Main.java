package ru.max;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       ApplicationContext contextKing = new AnnotationConfigApplicationContext(BeanConfigKing.class);
       ApplicationContext contextWeak = new AnnotationConfigApplicationContext(BeanConfigWeak.class);
       ApplicationContext contextStrong = new AnnotationConfigApplicationContext(BeanConfigStrong.class);
       Knight knightKing = contextKing.getBean(Knight.class);
       Knight knightWeak = contextWeak.getBean(Knight.class);
       Knight knightStrong = contextStrong.getBean(Knight.class);
       knightKing.fight();
       knightWeak.fight();
       knightStrong.fight();
    }
}
