package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Swagger;
import ru.bitte.moves.Thunder;
import ru.bitte.moves.Agility;

public class Pikachu extends Pichu {
    public Pikachu(String name, int value) {
        super(name, value);
        setType(Type.ELECTRIC);
        setStats(35, 55, 40, 50, 50, 90);
        setMove(new Swagger(), new Thunder(), new Agility());
    }
}
