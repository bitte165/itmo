package ru.bitte;

public class Street extends Location {
    private House house;
    public Street(String n, House h) {
        super(n);
        house = h;
    }
    public House getHouse() {
        return house;
    }
}
