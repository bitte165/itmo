package ru.bitte;

import java.util.Objects;

public abstract class Person {
    protected final String name;
    public Person(String n, Location l) {
        name = n;
        currentLocation = l;
    }

    public void enter(House h) {
        System.out.println(name + " заходит в место " + h.getName());
        setLocation(h.getRoom());
        System.out.println(name +  " попадает в помещение " + h.getRoom().getName());
    }

    public void enter(Room r) {
        setLocation(r);
        System.out.println(name +  " заходит в помещение " + r.getName());
    }


    protected String status;

    public String getStatus() {
        return "Статус: сущность " + status;
    }

    protected Location currentLocation;
    protected void setLocation(Location l) {
        currentLocation = l;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Person other = (Person) otherObject;
        return name.equals(other.name) && status.equals(other.status) && Objects.equals(currentLocation, other.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, currentLocation);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",status=" + status + ",currentLocation=" //
                + currentLocation.getName() + "]";
    }
}
