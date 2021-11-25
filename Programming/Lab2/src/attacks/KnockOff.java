package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class KnockOff extends PhysicalMove {
    public KnockOff() {
        super(Type.DARK, 65, 100);
    }

    @Override
    protected String describe(){
        return "attacks (Knock Off)";
    }
}
