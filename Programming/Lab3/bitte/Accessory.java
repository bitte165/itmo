package ru.bitte;

public enum Accessory {
    BRAIDED_MANE("Заплетенная в косички грива"), TAIL_TIP("Пушистая кисточка на хвосте"), DRESS("Пышное газовое платье"),
    FANCY_HAT("Большая модная шляпа"), LITTLE_DOG("Небольшая, курносая, рыжая, кудрявая собачонка");

    private Accessory(String description) { this.description = description; }
    public String getDescription() { return description; }

    private final String description;
}
