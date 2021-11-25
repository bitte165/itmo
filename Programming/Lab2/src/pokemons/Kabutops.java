package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.Flail;
import attacks.Roar;
import attacks.TeeterDance;
import attacks.Detect;

public class Kabutops extends Kabuto {
    public Kabutops(String name, int level) {
        super(name, level);
        setType(Type.ROCK, Type.WATER);
        setStats(60, 115, 105, 65, 70, 80);
        setMove(new Flail(), new TeeterDance(), new Roar(), new Detect());
    }
}
