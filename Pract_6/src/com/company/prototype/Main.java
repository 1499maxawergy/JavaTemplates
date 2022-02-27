package com.company.prototype;

import com.company.fabric.BMWFactory;
import com.company.fabric.Machine;
import com.company.fabric.MachineFactory;
import com.company.fabric.MazdaFactory;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.print();
        Prototype prototype2 = prototype.clone();
        prototype2.print();
    }
}
