package main.edson.one;

public class Herbivore extends Animal {
    public Herbivore(final String name, final String latinName) {
        super(name, latinName);
    }

    public String getDetails() {
        return String.format("%s (%s) makan tumbuhan.", name, latinName);
    }
}
