package ru.bitte;

import java.util.Objects;

public abstract class Location {
    private String name;
    protected Location innerLocation;
    public Location(String n) {
        name = n;
        innerLocation = null;
    }

    public String getName() {
        return name;
    }

    public boolean hasInnerLocation() {
        if (!(innerLocation == null)) {
            return true;
        } else {
            return false;
        }
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
