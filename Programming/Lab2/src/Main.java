import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Palkia p1 = new Palkia("1", 1);
        Kabuto p2 = new Kabuto("2", 1);
        Kabutops p3 = new Kabutops("3", 1);
        Pichu p4 = new Pichu("4", 1);
        Pikachu p5 = new Pikachu("5", 1);
        Raichu p6 = new Raichu("6", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
