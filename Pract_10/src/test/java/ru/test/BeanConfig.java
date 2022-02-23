package ru.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean
    public KingOfKnights kingOfKnights() {
        return new KingOfKnights();
    }

//    @Bean
//    public WeakKnight weakKnight() {
//        return new WeakKnight();
//    }
//
//    @Bean
//    public StrongKnight strongKnight() {
//        return new StrongKnight();
//    }

    @Bean
    public Knight knight(@Qualifier("kingOfKnights") IKnight knight){
        Knight knight1 = new Knight();
        knight1.setKnight(knight);
        return knight1;
    }

}
