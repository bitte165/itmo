package attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.*;

public class Detect extends StatusMove {
    public Detect() {
        super(Type.FIGHTING, 0, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().turns(1).condition(Status.SLEEP);
        p.setCondition(e);

    }

    @Override
    protected String describe(){
        return "attacks (Roar)";
    }
}
