package ru.bitte;

public class Dunno extends Person {
    public Dunno(String n, Location l) {
        super(n, l);
    }

    public void getEmployed() {
        Emotion hope = new Emotion() {
            @Override
            void setEmotion(String e) {
                emotion = e;
                if (!(emotion.equals(""))) {
                    boolean hopeIsPresent = true;
                } else {
                    boolean hopeIsPresent = false;
                }
            }
        };
        hope.setEmotion("появилась надежда");
        System.out.println(getName() + " устроился на работу, появилась надежда зарабоать деньги");
    }

    public void walk(Location s) {
        System.out.println(getName() + " идёт по месту " + s.getName());
    }

    public void ask(Person p, String question) {
        System.out.println(getName() + " спрашивает сущность " + p.getName() + ", " + question);
    }

    public class Emotion {
        protected String emotion = "flat";
        void setEmotion(String e) {
            emotion = e;
            System.out.println("Эмоция сущности " + getName() + " сменилась на " +  e);
        }
        String getEmotion() {
            return emotion;
        }
    }
}
