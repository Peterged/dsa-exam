package main.sistemhewan;

public abstract class Animal {
    private String name;
    private String latinName;

    protected Animal(final String name, final String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    public abstract String getFoodDetails();

    public String getName() {
        return name;
    }
    public String getLatinName() {
        return latinName;
    }   
}
