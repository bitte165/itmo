package ru.bitte;

public class Shorty extends Person implements Seeable {
    Shorty(String n, Location l) {
        super(n, l);
    }

    public void tell(Person p, String message) {
        System.out.println(name +  " говорит сущности " + p.getName() + ": \"" + message + "\"");
    }

}
