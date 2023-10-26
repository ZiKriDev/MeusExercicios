package entities;

public class Employee{
    private String name;
    private Integer id;
    private double salary;

    public Employee(String name, Integer id, Double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public Double getSalary(){
        return salary;
    }

    public void increaseSalary(double percentage){
        double result = salary + (salary*(percentage/100));
        this.salary = result;
    }

    @Override
    public String toString(){
        return String.format("%d", id)
        +", "
        +name
        +", "
        +String.format("%.2f", salary);
    }
}