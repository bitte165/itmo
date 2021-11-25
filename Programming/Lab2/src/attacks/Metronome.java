package attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.*;

public class Metronome extends StatusMove {
    public Metronome() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.prepareMove();

    }

    @Override
    protected String describe(){
        return "attacks (Metronome)";
    }
}
