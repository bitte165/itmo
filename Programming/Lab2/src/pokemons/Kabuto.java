package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.Flail;
import attacks.TeeterDance;
import attacks.Roar;


public class Kabuto extends Pokemon {
    public Kabuto(String name, int level) {
        super(name, level);
        setType(Type.ROCK, Type.WATER);
        setStats(30, 80, 90, 55, 45, 55);
        setMove(new Flail(), new TeeterDance(), new Roar());
    }
}
