package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove {
    public ThunderWave() {
        super(Type.ELECTRIC, 0, 90);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (!p.hasType(Type.ELECTRIC)) {
            Effect.paralyze(p);
        }
    }

    @Override
    protected String describe(){
        return "использует Thunder Wave - парализует противника";
    }
}
