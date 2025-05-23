package main.one;

public class Carnivore extends Animal {
    public Carnivore(final String name, final String latinName) {
        super(name, latinName);
    }

    @Override
    public String getFoodDetails() {
        return String.format("%s (%s) makan daging.", getName(), getLatinName());
    }
}
