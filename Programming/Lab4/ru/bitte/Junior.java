package ru.bitte;

public class Junior extends Person {
    private Puppy lap;
    Junior(String n, Location l) {
        super(n, l);
    }

    public void takeIntoLap(Puppy p) {
        lap = p;
        System.out.println(getName() + " взял на колени сущность " + p.getName());
    }

    public void whisper(Person p) {
        System.out.println(getName() + " шепнул что-то сущности " +  p.getName());
    }

    public class Emotion {
        private String emotion = "flat";
        void setEmotion(String e) {
            emotion = e;
            System.out.println("Эмоция сущности " + getName() + " сменилась на " +  e);
        }
        String getEmotion() {
            return emotion;
        }
    }
}
