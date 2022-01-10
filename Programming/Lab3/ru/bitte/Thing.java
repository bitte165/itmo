package ru.bitte;

import java.util.Objects;

public abstract class Thing {
    protected String name;
    public Thing(String n) {
        name = n;
    }

    protected String relation;
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Thing other = (Thing) otherObject;
        return name.equals(other.name) && relation.equals(other.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, relation);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",relation=" + relation + "]";
    }
}
