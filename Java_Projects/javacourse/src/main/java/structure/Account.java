package structure;

// Bank account
public class Account {
    private String owner;
    private double balance;
    private double minimumBalance;

    public void deposit(double amount) {
        // implementation
    }

    public double calculateCreditWorthiness() {
        return 100;
    }

    public void withdraw(double amount) {
        // implementation
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
