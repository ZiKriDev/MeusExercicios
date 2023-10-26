/* 
 * Estudo de caso 03: Fazer um programa para ler um número inteiro N e
 * depois os dados (id, nome, salário) de N funcionários. Não deve haver
 * repetição de id.
 * 
 * Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
 * Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar
 * uma mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários.
 * 
 * OBS: Um salário só pode ser modificado (aumentado) com base em uma operação de aumento por
 * porcentagem dada.
*/

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        List<Employee> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.printf("How many employees will be registered? ");
        int quantity = input.nextInt();
        System.out.println();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.printf("Id: ");
            Integer id = input.nextInt();

            while(hasId(list, id)){
                System.out.printf("Id already taken! Try again: ");
                id = input.nextInt();
            }

            input.nextLine();
            System.out.printf("Name: ");
            String name = input.nextLine();

            System.out.printf("Salary: ");
            double salary = input.nextDouble();

            Employee employee = new Employee(name, id, salary);
            list.add(employee);
            System.out.println();
        }

        System.out.printf("Enter the employee id that will have salary increase: ");
        Integer id = input.nextInt();


        if (!(hasId(list, id) == false)) {
            System.out.printf("Enter the percentage: ");
            double percentage = input.nextDouble();

            Employee employeeReceiveRaise = list.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
            employeeReceiveRaise.increaseSalary(percentage);

            int i = 0;
            for (Employee employee : list) {
                if (employee.getId().equals(id)) {
                    list.set(i, employeeReceiveRaise);
                }
                i++;
            }

            System.out.println();
            System.out.println("List of employees:");

            for (Employee employee : list) {
                System.out.println(employee);
            }
        } else {
            System.out.println("This id does not exist!");

            System.out.println();
            System.out.println("List of employees:");

            for (Employee employee : list) {
                System.out.println(employee);
            }
        }

        input.close();
    }

    public static boolean hasId(List<Employee> list, Integer id){
        for (Employee employee : list) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
