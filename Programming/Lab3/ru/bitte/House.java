package ru.bitte;

public class House extends Location implements Seeable {
    public House(String n) {
        super(n, new Room("Комната"));
    }


    public static class Room extends Location {
        public Room(String n) {
            super(n, null);
        }
    }
}
