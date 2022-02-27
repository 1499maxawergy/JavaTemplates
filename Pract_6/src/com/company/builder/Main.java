package com.company.builder;

public class Main {

    public static void main(String[] args) {
        Builder builder = new SFBuilder(); // работнику получил специальность создания СФа
        Director director = new Director(builder); // директору прикрепили данного сотрудника
        director.Construct(); // директор с помощью сотрудника создал сфа
        Hero hero = builder.getHero(); // сотрудник возвращает сделанную работу в ячейку
        hero.print(); // вывод работы

        builder = new PudgeBuilder(); // работник переквалифицировался на создание Пуджа
        director = new Director(builder); // директору прикрепили данного сотрудника
        director.Construct(); // поручил сделать
        hero = builder.getHero();
        hero.print();
    }
}
