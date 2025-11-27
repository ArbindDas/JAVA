package OOPS.Encapsulation;

class BankAccount {
    // Private fields → cannot be accessed directly outside this class
    private String accountNumber;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter → controlled access to account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter → controlled access to balance
    public double getBalance() {
        return balance;
    }

    // Setter → control how balance is updated
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Setter → controlled withdrawal
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal or insufficient balance!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("12345", 1000);

        // Access fields via getters/setters
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());

        // Deposit and withdraw using controlled methods
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000); // invalid withdrawal
    }
}
