package ru.bitte;

public class WoodenPartition extends Thing {
    public WoodenPartition(String n) {
        super(n);
        relation = "находится за объектом " + n;
    }
    private Person personBehind;
    public void setPersonBehind(Person p) {
        Person personBehind = p;
        p.status = relation;
    }
}
