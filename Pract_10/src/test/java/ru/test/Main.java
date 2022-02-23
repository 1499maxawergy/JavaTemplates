package ru.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
       Knight knight = context.getBean(Knight.class);
       knight.fight();
    }
}
