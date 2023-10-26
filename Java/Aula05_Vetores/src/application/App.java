/*
 * 
 * Estudo de caso 02: A dona de um pensionato possui dez quartos para 
 * alugar para estudantes, sendo esses quartos identificados pelos números 
 * 0 a 9. Fazer um programa que inicie com todos os dez quartos vazios, e 
 * depois leia uma quantidade N representando o número de estudantes que vão 
 * alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos 
 * N estudantes.
 * 
 * Para cada registro de aluguel, informar o nome e e-mail do estudante, bem como 
 * qual dos quartos ele escolheu (de 0 a 9). Suponha que seja escolhido um quarto vago.
 * Ao final, seu programa de imprimir um relatório de todas ocupações do pensionato, por 
 * ordem de quarto.
 */

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Room;
import entities.Student;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        String name;
        String email;

        Room[] r = new Room[10];

        System.out.printf("How many rooms will be rented? ");
        int numberOfRentals = input.nextInt();

        if (!(numberOfRentals > 0 && numberOfRentals <= 10)) {
            System.out.println("You cannot rent less than 1 room or more than 10 rooms!");
        } else {
            System.out.println();

            for (int i = 0; i < numberOfRentals; i++) {
                input.nextLine();
                System.out.println("Rent #" + (i + 1) + ":");

                System.out.printf("Name: ");
                name = input.nextLine();

                System.out.printf("Email: ");
                email = input.nextLine();

                System.out.printf("Room: ");
                int selectedRoom = input.nextInt();

                System.out.println();

                Student student = new Student(name, email);
                r[selectedRoom - 1] = new Room(student, selectedRoom);
            }

            System.out.println("Busy rooms:");

            for (int i = 0; i < r.length; i++) {
                if (r[i] != null) {
                    System.out.println(r[i]);
                }
            }

            input.close();
        }
    }
}
