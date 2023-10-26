package entities;

public class Account {
    private int numberAccount;
    private String name;
    private double initialDeposit;
    private double balance;
    private final double TAX_VALUE = 5.0;

    public Account(int numberAccount, String name, double initialDeposit) {
        this.numberAccount = numberAccount;
        this.name = name;
        this.initialDeposit = initialDeposit;
        deposit(initialDeposit);
    }

    public Account(int numberAccount, String name) {
        this.numberAccount = numberAccount;
        this.name = name;
        deposit(initialDeposit);
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= (value + TAX_VALUE);
    }

    public String toString() {
        return "Account "
                + String.format("%d, ", getNumberAccount())
                + "Holder: "
                + getName()
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
