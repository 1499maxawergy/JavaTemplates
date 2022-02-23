package ru.max;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigKing {

    @Bean
    public KingOfKnights kingOfKnights() {
        return new KingOfKnights();
    }

    @Bean
    public Knight knightKing(IKnight knight) {
        Knight prince = new Knight();
        prince.setKnight(knight);
        return prince;
    }

}
