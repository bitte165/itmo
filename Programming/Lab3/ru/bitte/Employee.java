package ru.bitte;

public class Employee extends Person implements Seeable {
    Employee(String n, Location l) {
        super(n, l);
    }

    public void speakOnPhone() {
        System.out.println(name + " разговаривает по телефону ");
    }
}
