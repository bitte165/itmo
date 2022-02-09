package ru.bitte;

public class Hostess extends Person implements Describeable {
    public Hostess(String n, Location l) {
        super(n, l);
    }

    private final Accessory[] accessories = {Accessory.DRESS, Accessory.FANCY_HAT};
    public Accessory[] getAccessories() {
        return accessories;
    }
}
