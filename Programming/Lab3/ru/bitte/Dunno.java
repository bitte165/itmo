package ru.bitte;

public class Dunno extends Person {
    public Dunno(String n, Location l) {
        super(n, l);
    }

    public void getEmployed() {
        System.out.println(getName() + " устроился на работу, появилась надежда зарабоать деньги");
    }

    public void see(Seeable obj) {
        if (obj instanceof Person) {
            System.out.println(getName() + " увидел сущность " + obj.getName());
        } else if (obj instanceof Location) {
            System.out.println(name + " увидел " + obj.getName());
        }
    }

    public void walk(Street s) {
        System.out.println(name + " идёт по месту " + s.getName());
        see(s.getHouse());
    }

    public void ask(Person p, String question) {
        System.out.println(name + " спрашивает сущность " + p.getName() + ", " + question);
    }

}
