package ru.bitte;

public class Maid extends Person implements Describeable {
    public Maid(String n, Location l) {
        super(n, l);
    }

    private final Accessory[] accessories = {Accessory.LITTLE_DOG};
    public Accessory[] getAccessories() {
        return accessories;
    }
}
