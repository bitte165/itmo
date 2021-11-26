package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.CalmMind;
import ru.bitte.moves.Psychic;
import ru.bitte.moves.Confide;
import ru.bitte.moves.ZenHeadbutt;

public class Seaking extends Goldeen {
    public Seaking(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(80, 92, 65, 65, 80, 68);
        setMove(new CalmMind(), new Psychic(), new Confide(), new ZenHeadbutt());
    }
}
