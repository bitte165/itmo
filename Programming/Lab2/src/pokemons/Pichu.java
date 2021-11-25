package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.Headbutt;
import attacks.Wrap;

import java.awt.*;

public class Pichu extends Pokemon {
    public Pichu(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(20, 40, 15, 35, 35, 60);
        setMove(new Headbutt(), new Wrap());
    }
}
