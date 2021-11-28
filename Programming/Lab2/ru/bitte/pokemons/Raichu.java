package ru.bitte.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.bitte.moves.Swagger;
import ru.bitte.moves.Thunder;
import ru.bitte.moves.Agility;
import ru.bitte.moves.ThunderWave;

public class Raichu extends Pikachu {
    public Raichu(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(60, 90, 55, 90, 80, 110);
        setMove(new Swagger(), new Thunder(), new Agility(), new ThunderWave());
    }

}
