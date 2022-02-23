package ru.max;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigWeak {
    
    @Bean
    public WeakKnight weakKnight(){
        return new WeakKnight();
    }

    @Bean
    public Knight knightWeak(IKnight knight) {
        Knight prince = new Knight();
        prince.setKnight(knight);
        return prince;
    }
}
