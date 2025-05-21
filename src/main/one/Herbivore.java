package main.one;

public class Herbivore extends Animal {
    public Herbivore(final String name, final String latinName) {
        super(name, latinName);
    }

    @Override
    public String getDetails() {
        return String.format("%s (%s) makan tumbuhan.", name, latinName);
    }
}
