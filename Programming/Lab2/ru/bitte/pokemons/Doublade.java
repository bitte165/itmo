package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Confide;
import ru.bitte.moves.Facade;
import ru.bitte.moves.WaterPulse;

public class Doublade extends Honedge {
    public Doublade(String name, int level) {
        super(name, level);
        setType(Type.STEEL, Type.GHOST);
        setStats(59, 110, 150, 45, 49, 35);
        setMove(new Confide(), new Facade(), new WaterPulse());
    }
}
