package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.FireBlast;
import ru.bitte.moves.Flamethrower;
import ru.bitte.moves.Growl;
import ru.bitte.moves.QuickAttack;

public class Rapidash extends Ponyta {
    public Rapidash(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(65, 100, 70, 80, 80, 105);
        setMove(new FireBlast(), new Flamethrower(), new Growl(), new QuickAttack());
    }
}
