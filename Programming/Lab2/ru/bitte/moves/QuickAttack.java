package ru.bitte.moves;

import ru.ifmo.se.pokemon.*;

public class QuickAttack extends PhysicalMove {
    public QuickAttack() {
        super(Type.NORMAL, 40, 100);
    }

    @Override
    protected String describe(){
        return "использует Quick Attack";
    }
}
