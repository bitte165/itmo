package ru.bitte;

import java.util.ArrayList;

public class Bench extends Thing {
    public Bench(String n) {
        super(n);
        relation = " сидит на объекте " + n;
    }

    private ArrayList<Person> members = new ArrayList<>();
    public void addMembers(Person... ms) {
        for (Person member : ms) {
            members.add(member);
            member.status = member.getName() + relation;
        }
    }

    public void seatedBy(Person p) {
        members.add(p);
        System.out.println(p.getName() + " садится на объект " + name);
    }
}
