package ru.bitte;

import java.util.Objects;

public abstract class Person {
    private final String name;
    private Location currentLocation;
    public Person(String n, Location l) {
        name = n;
        currentLocation = l;
    }

    protected void setLocation(Location l) {
        currentLocation = l;
    }

    public void enter(Location  l) {
        setLocation(l);
        System.out.println(name +  " заходит в помещение " + l.getName());
        if (l.hasInnerLocation()) {
            setLocation(l.innerLocation);
            System.out.println(name +  " попадает в помещение " + l.innerLocation.getName());
        }
    }

    public void leave() {
        System.out.println(name +  " покидает помещение " + currentLocation.getName());
        setLocation(null);
    }

    public void currentLocation() {
        System.out.println(name +  " находится в помещении " + currentLocation.getName());
    }

    public Location getLocation() {
        return currentLocation;
    }

    protected String status;
    public void getStatus() {
        System.out.println("Статус сущности " + getName() + ": сущность " + status);
    }

    public String getName() {
        return name;
    }

    public void see(Seeable obj) {
        if (obj instanceof Person) {
            System.out.println(getName() + " увидел сущность " + obj.getName());
        } else if (obj instanceof Location) {
            System.out.println(getName() + " увидел " + obj.getName());
        } else {
            System.out.println(getName() + " видит " + obj.getName());
        }
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
