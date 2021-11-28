package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.LowSweep;
import ru.bitte.moves.Waterfall;
import ru.bitte.moves.FireBlast;
import ru.bitte.moves.Blizzard;

public class Mew extends Pokemon {
    public Mew(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(100, 100, 100, 100, 100, 100);
        setMove(new LowSweep(), new Waterfall(), new FireBlast(), new Blizzard());
    }
}
