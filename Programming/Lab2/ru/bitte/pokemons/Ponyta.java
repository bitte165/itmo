package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.FireBlast;
import ru.bitte.moves.Flamethrower;
import ru.bitte.moves.Growl;

public class Ponyta extends Pokemon {
    public Ponyta(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(50, 85, 55, 65, 65, 90);
        setMove(new FireBlast(), new Flamethrower(), new Growl());
    }
}
