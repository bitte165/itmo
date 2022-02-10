package ru.bitte;

import java.util.Objects;

public abstract class Location {
    private final String name;
    private final Location innerLocation;
    public Location(String n, Location l) {
        name = n;
        innerLocation = l;
    }

    public String getName() {
        return name;
    }

    public Location getInnerLocation() {
        return innerLocation;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Location other = (Location) otherObject;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + "]";
    }
}
