package ru.bitte;

public class House extends Location implements Seeable {
    private Room room;
    public House(String n, Room r) {
        super(n);
        room = r;
    }

    public Room getRoom() {
        return room;
    }
}
