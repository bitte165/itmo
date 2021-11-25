package attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.*;

public class Roar extends StatusMove {
    public Roar() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.flinch(p);
    }

    @Override
    protected String describe(){
        return "attacks (Roar)";
    }
}
