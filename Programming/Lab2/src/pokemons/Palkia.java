package pokemons;
import ru.ifmo.se.pokemon.*;
import attacks.KnockOff;
import attacks.Metronome;
import attacks.TakeDown;
import attacks.Growth;

public class Palkia extends Pokemon {
    public Palkia(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.DRAGON);
        setStats(90, 120, 100, 150, 120, 100);
        setMove(new KnockOff(), new Metronome(), new TakeDown(), new Growth());
    }
}
