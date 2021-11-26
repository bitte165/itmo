package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().turns(2).condition(Status.SLEEP);
        p.restore();
        p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "attacks (Rest)";
    }
}
