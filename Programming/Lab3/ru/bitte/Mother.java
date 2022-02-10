package ru.bitte;

public class Mother extends Person {
    Mother(String n, Location l) {
        super(n, l);
    }

    public void callNumber(int number) {
        System.out.println(getName() + " позвонила по номеру " + number);
        status = "говорит по телефону";
    }

    public void sayOnPhone(String m) {
        if (status == "говорит по телефону") {
            System.out.println(getName() + " говорит по телефону, что " + m);
        }
    }
}