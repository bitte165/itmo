package ru.bitte;

public class Puddle extends Person implements Describeable {
    public Puddle(String n, Location l) {
        super(n, l);
    }

    private final Accessory[] accessories = {Accessory.BRAIDED_MANE, Accessory.TAIL_TIP};
    public Accessory[] getAccessories() {
        return accessories;
    }
}
