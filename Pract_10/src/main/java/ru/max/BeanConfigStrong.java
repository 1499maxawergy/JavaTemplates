package ru.max;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigStrong {

    @Bean
    public StrongKnight strongKnight(){
        return new StrongKnight();
    }

    @Bean
    public Knight knightStrong(IKnight knight) {
        Knight prince = new Knight();
        prince.setKnight(knight);
        return prince;
    }
}
