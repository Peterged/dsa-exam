package main.sistemhewan;

public class Main {
    public static void main(String[] args) {
        Animal rusa = new Herbivore("Rusa", "Cervidae");
        Animal harimau = new Carnivore("Harimau", "Panthera tigris");

        System.out.println(rusa.getFoodDetails());
        System.out.println(harimau.getFoodDetails());
    }
}