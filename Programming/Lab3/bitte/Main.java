package ru.bitte;

public class Main {
    public static void main(String[] args) {
        Room room = new Room("Комната");
        House house = new House("Дом с вывеской \"Контора по найму собачьих нянь\"", room);
        Street street = new Street("Улица", house);
        Dunno dunno = new Dunno("Незнайка", street);
        dunno.getEmployed();
        dunno.walk(street);
        dunno.enter(house);
        Bench bench = new Bench( "Лавочка");
        Shorty shorties = new Shorty("Коротышки", room);
        Shorty shorty = new Shorty("Коротышка", room);
        bench.addMembers(shorties, shorty);
        dunno.see(shorties);
        System.out.println(shorties.getStatus());
        WoodenPartition wp = new WoodenPartition("Деревянная перегородка");
        Employee employee = new Employee("Сотрудник конторы", room);
        wp.setPersonBehind(employee);
        dunno.see(employee);
        System.out.println(employee.getStatus());
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
            for (int i = 0; i < a.length - 1; i++) {
                System.out.print(a[i].getDescription() + "; ");
            }
            System.out.println(a[a.length - 1].getDescription());
        }

    }
}
