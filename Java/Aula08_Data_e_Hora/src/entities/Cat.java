package entities;

public class Cat extends Animal{
    private double peso;

    public double calcIMC() {
        double result = getHeight() * peso;

        return result;
    }
}
