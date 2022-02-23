package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Human> vector = new ArrayList<>();
        vector.add(new Human(52, "Sanya", "Loshkarev", LocalDate.of(1970,1,1),  62));
        vector.add(new Human(32, "Kolyasik", "Mochalkin", LocalDate.of(1987,3, 17),  322));
        vector.add(new Human(11, "Mishanya", "Invokerovich", LocalDate.of(2010, 4, 10),  91));
        System.out.println("Name:");
        vector.stream()
                .sorted(Comparator.comparing(d -> d.getFirstName()))
                .forEach(System.out::println);

        System.out.println("Date:");
        vector.stream()
                .filter(d -> d.getBirthDate()
                        .isAfter(LocalDate.of(2000, 6, 24)))
                .forEach(System.out::println);

        System.out.println("Surname:");
        vector.stream()
                .sorted(Comparator.comparing(d -> d.getLastName()))
                .forEach(System.out::println);

        System.out.println("Sum of ages:" + vector.stream()
                .mapToInt(Human::getAge)
                .sum());

    }
}
