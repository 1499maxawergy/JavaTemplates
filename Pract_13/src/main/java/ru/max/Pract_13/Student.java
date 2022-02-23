package ru.max.Pract_13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void init(){
        System.out.println(name + "\n" + last_name + "\n" + group);
    }
}
