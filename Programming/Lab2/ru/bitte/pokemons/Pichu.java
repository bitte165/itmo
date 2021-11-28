package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Swagger;
import ru.bitte.moves.Thunder;

public class Pichu extends Pokemon {
    public Pichu(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(20, 40, 15, 35, 35, 60);
        setMove(new Swagger(), new Thunder());
    }
}
