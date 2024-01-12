/*
 * 
 * Estudo de caso: Criar uma aplicação que lê os dados de um trabalhador com 
 * N contratos (N fornecido pelo usuário). Depois, solicitar do usuário um mês 
 * e mostrar qual foi o salário do funcionário nesse mês.
 * 
 * Diagrama de classe: https://i.imgur.com/arwRqiI.png
 * 
 */

package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        Department department = createDepartment(input);

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = input.nextLine();

        WorkerLevel workerLevel = getValidWorkerLevel(input);
        Double baseSalary = getValidDoubleInput(input, "Base salary");
        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);

        int numberOfContracts = getValidIntInput(input, "How many contracts to this worker?");
        for (int i = 0; i < numberOfContracts; i++) {
            HourContract contract = createHourContract(input);
            worker.addContract(contract);
        }

        String monthAndYear = getValidMonthAndYear(input, "Enter month and year to calculate income (MM/YYYY): ");
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println();
        System.out.println(worker);
        System.out.printf("Income for %s: %.2f", monthAndYear, worker.income(month, year));

        input.close();
    }

    // Construir departamento
    private static Department createDepartment(Scanner input) {
        System.out.print("Enter department's name: ");
        String departmentName = input.nextLine();
        return new Department(departmentName);
    }

    // Receber entradas válidas do tipo enum
    private static WorkerLevel getValidWorkerLevel(Scanner input) {
        WorkerLevel workerLevel;
        do {
            System.out.print("Level: ");
            try {
                workerLevel = WorkerLevel.valueOf(input.nextLine());
            } catch (IllegalArgumentException e) {
                workerLevel = null;
                System.out.println("Error! Enter a valid entry for level.");
            }
        } while (workerLevel == null);
        return workerLevel;
    }
    

    // Receber entradas válidas do tipo Double
    private static Double getValidDoubleInput(Scanner input, String prompt) {
        Double value;
        do {
            System.out.print(prompt + ": ");
            value = input.hasNextDouble() ? input.nextDouble() : null;

            if (value == null) {
                System.out.println("Error! Enter a valid entry for this!");
            }
            input.nextLine(); 
        } while (value == null);
        return value;
    }

    // Receber entradas válidas do tipo int
    private static Integer getValidIntInput(Scanner input, String prompt) {
        Integer value;
        do {
            System.out.print(prompt + " ");
            value = input.hasNextInt() ? input.nextInt() : null;

            if (value == null) {
                System.out.println("Error! Enter a valid entry for this!");
            }
            input.nextLine();
        } while (value == null);
        return value;
    }

    // Receber entradas válidas do tipo String (datas)
    private static String getValidDateString(Scanner input) {
        String dateString;
        do {
            System.out.print("Date (DD/MM/YYYY): ");
            dateString = input.nextLine();
        } while (!validateDate(dateString));
        return dateString;
    }

    // Receber entradas válidas do tipo String (datas para mês e ano)
    private static String getValidMonthAndYear(Scanner input, String prompt) {
        String monthAndYear;
        do {
            System.out.print(prompt);
            monthAndYear = input.nextLine();
        } while (!validateMonthAndYear(monthAndYear));
        return monthAndYear;
    }

    // Construir contrato
    private static HourContract createHourContract(Scanner input) throws Exception {
        System.out.println("Enter contract data:");
        String dateString = getValidDateString(input);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        Double valuePerHour = getValidDoubleInput(input, "Value per hour");
        Integer hours = getValidIntInput(input, "Duration (hours)");
        return new HourContract(date, valuePerHour, hours);
    }

    // Validar datas usando como formato a máscara "dd/MM/yyyy"
    private static boolean validateDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            format.parse(date);
            return true;
        } catch (Exception e) {
            System.out.println("Error! Enter a valid entry for date.");
            return false;
        }
    }

    // Validar mês e ano para buscar dados referentes a renda do trabalhador
    private static boolean validateMonthAndYear(String monthAndYear) {
        try {
            int month = Integer.parseInt(monthAndYear.substring(0, 2));
            int year = Integer.parseInt(monthAndYear.substring(3));
            return month >= 1 && month <= 12 && year >= 2000;
        } catch (Exception e) {
            System.out.println("Error! Enter a valid entry for date.");
            return false;
        }
    }
}

