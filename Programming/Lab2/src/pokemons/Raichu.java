package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.Headbutt;
import attacks.Wrap;
import attacks.RockTomb;
import attacks.Metronome;

public class Raichu extends Pikachu {
    public Raichu(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(60, 90, 55, 90, 80, 100);
        setMove(new Headbutt(), new Wrap(), new RockTomb(), new Metronome());
    }

}
