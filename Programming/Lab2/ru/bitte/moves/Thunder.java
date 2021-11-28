package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {
    public Thunder() {
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (!p.hasType(Type.ELECTRIC) && Math.random() < 0.3) {
            Effect.paralyze(p);
        }
    }

    @Override
    protected String describe(){
        return "использует Thunder";
    }
}
