package main;

import bank.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setAccountNumber("1234");
        account.setCustomerName("Johnny");
        account.setBalance(200.0);

        account.deposit(100.0);
        account.withdraw(300.0);

        account.getBalance();

        System.out.println("Account Balance: " + account.getBalance());

    }
}
