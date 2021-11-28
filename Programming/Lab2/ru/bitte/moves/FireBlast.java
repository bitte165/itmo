package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
    public FireBlast() {
        super(Type.FIRE, 110, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (!p.hasType(Type.FIRE) && Math.random() < 0.1) {
            Effect.burn(p);
        }
    }

    @Override
    protected String describe(){
        return "использует Fire Blast";
    }
}
