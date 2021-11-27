package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        if (att.getCondition() == Status.BURN || att.getCondition() == Status.POISON ||
                att.getCondition() == Status.PARALYZE) {
            this.power *= 2;
            double damage = super.calcBaseDamage(att, def);
            this.power /= 2;
            return damage;

        } else {
            return super.calcBaseDamage(att, def);
        }
    }

    @Override
    protected String describe() {
        return "использует Facade";
    }
}
