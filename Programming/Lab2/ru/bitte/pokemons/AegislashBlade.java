package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Confide;
import ru.bitte.moves.Facade;
import ru.bitte.moves.WaterPulse;
import ru.bitte.moves.Bite;

public class AegislashBlade extends Doublade {
    public AegislashBlade(String name, int level) {
        super(name, level);
        setType(Type.STEEL, Type.GHOST);
        setStats(60, 50, 140, 50, 140, 60);
        setMove(new Confide(), new Facade(), new WaterPulse(), new Bite());
    }
}
