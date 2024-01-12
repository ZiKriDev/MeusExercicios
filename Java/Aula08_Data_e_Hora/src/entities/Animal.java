package entities;

public class Animal {
    protected double height;
    public String name;
    private int age;

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
