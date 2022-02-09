package ru.bitte;

public class House extends Location implements Seeable {
    public House(String n) {
        super(n);
        innerLocation = new Room("Комната");
    }


    public class Room extends Location {
        public Room(String n) {
            super(n);
        }

    }
}
