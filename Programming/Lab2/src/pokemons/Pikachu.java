package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.Headbutt;
import attacks.Wrap;
import attacks.RockTomb;

public class Pikachu extends Pichu {
    public Pikachu(String name, int value) {
        super(name, value);
        setType(Type.ELECTRIC);
        setStats(35, 55, 40, 50, 50, 90);
        setMove(new Headbutt(), new Wrap(), new RockTomb());
    }
}
