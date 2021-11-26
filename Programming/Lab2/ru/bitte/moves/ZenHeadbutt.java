package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class ZenHeadbutt extends PhysicalMove {
    public ZenHeadbutt() {
        super(Type.PSYCHIC, 80, 90);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.2) {
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe() {
        return "attacks (Zen Headbutt)";
    }
}
