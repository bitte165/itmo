package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Confide;
import ru.bitte.moves.Facade;

public class Honedge extends Pokemon {
    public Honedge(String name, int level) {
        super(name, level);
        setType(Type.STEEL, Type.GHOST);
        setStats(45, 80, 100, 35, 37, 28);
        setMove(new Confide(), new Facade());
    }
}
