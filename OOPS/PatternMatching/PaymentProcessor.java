package OOPS.PatternMatching;




abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
}

class CreditCard extends Payment {
    String cardNumber;
    CreditCard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
}

class PayPal extends Payment {
    String email;
    PayPal(double amount, String email) {
        super(amount);
        this.email = email;
    }
}

class BankTransfer extends Payment {
    String accountNumber;
    BankTransfer(double amount, String accountNumber) {
        super(amount);
        this.accountNumber = accountNumber;
    }
}

public class PaymentProcessor {
    public static void processPayment(Payment payment) {
        // Pattern matching with instanceof
        if (payment instanceof CreditCard cc) {
            System.out.println("Processing credit card payment of $" + cc.amount + " from card: " + cc.cardNumber);
        } else if (payment instanceof PayPal pp) {
            System.out.println("Processing PayPal payment of $" + pp.amount + " from email: " + pp.email);
        } else if (payment instanceof BankTransfer bt) {
            System.out.println("Processing bank transfer of $" + bt.amount + " from account: " + bt.accountNumber);
        } else {
            System.out.println("Unknown payment type");
        }
    }

    public static void main(String[] args) {
        Payment p1 = new CreditCard(500, "1234-5678-9876-5432");
        Payment p2 = new PayPal(200, "user@example.com");
        Payment p3 = new BankTransfer(1000, "AC987654321");

        processPayment(p1);
        processPayment(p2);
        processPayment(p3);
    }
}
