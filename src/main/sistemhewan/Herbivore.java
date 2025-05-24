package main.sistemhewan;

public class Herbivore extends Animal {
    public Herbivore(final String name, final String latinName) {
        super(name, latinName);
    }

    @Override
    public String getFoodDetails() {
        return String.format("%s (%s) makan tumbuhan.", getName(), getLatinName());
    }
}
