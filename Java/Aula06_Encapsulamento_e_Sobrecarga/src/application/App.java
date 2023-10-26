/* 
 * 
 * Estudo de caso 01: Em um banco, para se cadastrar uma conta bancária, é necessário informar o número 
 * da conta, o nome do titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a 
 * conta. Este valor de depósito inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a 
 * depositar no momento de abrir sua conta, o depósito inicial não será feito e o saldo inicial da conta será, 
 * naturalmente, zero. 
 * 
 * Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser alterado. Já o nome 
 * do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasião de casamento, por exemplo).
 * 
 * Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger isso. O 
 * saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para cada saque realizado, o banco cobra 
 * uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo não for suficiente para realizar o saque 
 * e/ou pagar a taxa.
 * 
 * Fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não informado o valor de depósito 
 * inicial. Em seguida, realizar um depósito e depois um saque, sempre mostrando os dados da conta após cada operação.
 * 
*/

package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Account account;

        int accountNumber;
        double value = 0.0;
        String name;
        char option;

        System.out.printf("Enter account number: ");
        accountNumber = input.nextInt();
        input.nextLine();

        System.out.printf("Enter account holder: ");
        name = input.nextLine();

        System.out.printf("Is there an initial deposit (y/n)? ");
        option = input.next().charAt(0);

        if (option == 'y') {
            System.out.printf("Enter initial deposit value: ");
            value = input.nextDouble();

            account = new Account(accountNumber, name, value);
        } else {
            account = new Account(accountNumber, name);
        }

        System.out.printf("%nAccount data: %n%s", account);

        System.out.println();
        System.out.printf("%nEnter a deposit value: ");
        value = input.nextDouble();

        account.deposit(value);

        System.out.printf("Updated account data: %n%s", account);

        System.out.printf("%n");
        System.out.printf("%nEnter a withdraw value: ");
        value = input.nextDouble();

        account.withdraw(value);

        System.out.printf("Updated account data: %n%s", account);

        input.close();
    }
}
