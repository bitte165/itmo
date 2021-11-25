package attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.*;

public class TeeterDance extends StatusMove {
    public TeeterDance() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.confuse();
    }

    @Override
    protected String describe(){
        return "attacks (Teeter Dance)";
    }
}
