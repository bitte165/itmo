package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class Wrap extends PhysicalMove {
    public Wrap() {
        super(Type.NORMAL, 15, 90);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        int n = 4;
        if (Math.random() >= 0.5) {
            n = 5;
        }
        Effect e = new Effect().turns(n).stat(Stat.HP, (int)(p.getStat(Stat.HP) * (1/8)));
        p.setCondition(e);
    }

    @Override
    protected String describe() {
        return "attacks (Wrap)";
    }
}
