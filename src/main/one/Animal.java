package main.edson.one;

public class Animal {
    protected String name;
    protected String latinName;

    protected Animal(final String name, final String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    protected String getDetails() {
        return "";
    }
}
