package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.CalmMind;
import ru.bitte.moves.Psychic;
import ru.bitte.moves.Confide;

public class Goldeen extends Pokemon {
    public Goldeen(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(45, 67, 60, 35, 50, 63);
        setMove(new CalmMind(), new Psychic(), new Confide());
    }
}
