package ru.bitte;

public class Puppy extends Person {
    Puppy(String n, Location l) {
        super(n, l);

    }

    public void lick(Person p) {
        System.out.println(getName() + " лизнул сущность " + getName());
    }

    public void sleep() {
        status = "спит";
        System.out.println(getName() + " засыпает...");
    }

    public static class Collar implements Seeable {
        private String name;
        private int collarSign;
        Collar(String n) throws NumberTooSmall {
            name = n;
            collarSign = (int) (Math.random() * 1000000);
            if (collarSign < 100000) {
                throw new NumberTooSmall();
            }
        }
        int getCollarSign() {
            return collarSign;
        }

        public String getName() {
            return name;
        }
    }
}

class NumberTooSmall extends Exception {

    public NumberTooSmall() {
        super();
    }
}