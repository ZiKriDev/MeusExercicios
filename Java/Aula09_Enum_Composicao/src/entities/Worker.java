package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
    
    // Campos
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    // Associações
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {}

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    
    // Adicionar contrato
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    // Remover contrato
    public void removeContract(HourContract contract){
        Iterator<HourContract> iterator = contracts.iterator();

        while(iterator.hasNext()) {
            HourContract hourContract = iterator.next();

            if (hourContract.equals(contract)) {
                iterator.remove();
            }
        }
    }

    // Calcular a renda em dado mês/ano
    public Double income(Integer month, Integer year){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();

        for (HourContract contract : contracts) {
            cal.setTime(contract.getDate());
            int contract_year = cal.get(Calendar.YEAR);
            int contract_month = 1 + cal.get(Calendar.MONTH);
            
            if (month == contract_month && year == contract_year) {
                sum += contract.totalValue();
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Name: "
               +name
               +"\n"
               +"Department: "
               +department.getName();
    }
}
