package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Tackle;
import ru.bitte.moves.ChargeBeam;
import ru.bitte.moves.Rest;
import ru.bitte.moves.TakeDown;

public class Meloetta extends Pokemon {
    public Meloetta(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.PSYCHIC);
        setStats(100, 77, 77, 128, 128, 90);
        setMove(new Tackle(), new ChargeBeam(), new Rest(), new TakeDown());
    }
}
