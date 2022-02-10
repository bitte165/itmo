package ru.bitte;

public class Main {
    public static void main(String[] args) {
        // lab 3 cond
        House house = new House("Дом с вывеской \"Контора по найму собачьих нянь\"");
        House.Room room = (House.Room) house.getInnerLocation();
        Street street = new Street("Улица");
        Dunno dunno = new Dunno("Незнайка", street);
        dunno.getEmployed();
        dunno.walk(street);
        dunno.see(house);
        dunno.enter(house);
        Bench bench = new Bench("Лавочка");
        Shorty shorties = new Shorty("Коротышки", room);
        Shorty shorty = new Shorty("Коротышка", room);
        bench.addMembers(shorties, shorty);
        dunno.see(shorties);
        shorties.getStatus();
        WoodenPartition wp = new WoodenPartition("Деревянная перегородка");
        Employee employee = new Employee("Сотрудник конторы", room);
        wp.setPersonBehind(employee);
        dunno.see(employee);
        employee.getStatus();
        employee.speakOnPhone();
        bench.seatedBy(dunno);
        dunno.ask(shorty, "кто такие собачьи няни и для чего их нанимают");
        shorty.tell(dunno, "Они ухаживают за собаками");
        Person[] ds = {new Puddle("Большой белый пудель", house), new Hostess("Хозяйка", house),
                new Maid("Служанка", house)};
        for (Person p : ds) {
            p.enter(room);
            Describeable d = (Describeable) p;
            System.out.print(p.getName() + " имеет аттрибуты: ");
            Accessory[] a = d.getAccessories();
            try {
                for (int i = 0; i <= a.length; i++) {
                    System.out.print(a[i].getDescription() + "; ");
                }
                System.out.println(a[a.length - 1].getDescription());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("нет больше элементов...");
            }
        }
        System.out.println();
        // lab 4 cond
        Children children = new Children("Дети", room);
        children.leave();
        Gunilla gunilla = new Gunilla("Гунилла", room);
        gunilla.leave();
        Krister krsiter = new Krister("Кристер", room);
        krsiter.leave();
        Junior junior = new Junior("Малыш", room);
        Puppy puppy = new Puppy("Щенок", room);
        junior.currentLocation();
        puppy.currentLocation();
        if (gunilla.getCurrentLocation() != room && krsiter.getCurrentLocation() != room
                && junior.getCurrentLocation() == room && puppy.getCurrentLocation() == room) {
            System.out.println(junior.getName() + " и " + puppy.getName() + " остались вдвоем в помещении " + room.getName());
        }
        Junior.Emotion emotion = junior.new Emotion();
        emotion.setEmotion("Радость");
        junior.takeIntoLap(puppy);
        junior.whisper(puppy);
        puppy.sleep();
        puppy.getStatus();
        Laundry laundry = new Laundry("Прачечная");
        Mother mother = new Mother("Мама", laundry);
        mother.leave();
        mother.enter(room);
        if (mother.getCurrentLocation() == room) {
            System.out.println("Обстановка изменяется...");
        }
        emotion.setEmotion("Грусть");
        try {
            Puppy.Collar collar = new Puppy.Collar("Ошейник Щенка с выгравированном на нём номером");
            mother.see(collar);
            mother.callNumber(collar.getCollarSign());
            mother.sayOnPhone("ее сын нашел маленького черного щенка-пуделя");
        } catch (NumberTooSmall e) {
            System.out.println("Номер сгенерировался неправильно...");
        }
    }
}
