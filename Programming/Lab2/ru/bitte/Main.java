package ru.bitte;

import ru.ifmo.se.pokemon.*;
import ru.bitte.pokemons.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Meloetta p1 = new Meloetta("1", 1);
        Goldeen p2 = new Goldeen("2", 1);
        Seaking p3 = new Seaking("3", 1);
        Honedge p4 = new Honedge("4", 1);
        Doublade p5 = new Doublade("5", 1);
        AegislashBlade p6 = new AegislashBlade("6", 1);
        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);
        b.go();
    }
}