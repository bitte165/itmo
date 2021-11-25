package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class TakeDown extends PhysicalMove {
    public TakeDown() {
        super(Type.NORMAL, 90, 85);
    }

    @Override
    protected void applySelfDamage(Pokemon p, double damage) {
        p.setMod(Stat.HP, (int) ((1 / 4) * damage));
        super.applySelfDamage(p, damage);
    }

    @Override
    protected String describe(){
        return "attacks (Take Down)";
    }
}
