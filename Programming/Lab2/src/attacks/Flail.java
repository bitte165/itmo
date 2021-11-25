package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class Flail extends PhysicalMove {
    public Flail() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        int n = (int)(48 * att.getStat(Stat.HP) / att.getHP());
        if (0 <= n && n < 2) {
            this.power = 200;
        } else if (2 <= n && n < 4) {
            this.power = 150;
        } else if (5 <= n && n < 9) {
            this.power = 100;
        } else if (10 <= n && n < 16) {
            this.power = 80;
        } else if (17 <= n && n < 32) {
            this.power = 40;
        } else if (33 <= n && n < 48) {
            this.power = 20;
        }
        return super.calcBaseDamage(att, def);
    }
    @Override
    protected String describe(){
        return "attacks (Flail)";
    }
}
