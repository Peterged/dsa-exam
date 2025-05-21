package main.edson.one;

public class Carnivore extends Animal {
    public Carnivore(final String name, final String latinName) {
        super(name, latinName);
    }

    public String getDetails() {
        return String.format("%s (%s) makan daging.", name, latinName);
    }
}
