
package OOPS.ModernJava;

// Sealed abstract class representing generic Payment
// Purpose: Restrict which types of payments are allowed
sealed abstract class Payment permits CreditCard, PayPal, BankTransfer {
    private double amount; // Encapsulation: private field

    Payment(double amount) { // Constructor
        this.amount = amount;
    }

    public double getAmount() { // Getter for encapsulation
        return amount;
    }

    // Abstract method → must be implemented by subclasses
    abstract void process(); 
}

// Final class → cannot be subclassed further
final class CreditCard extends Payment {
    private String cardNumber;

    CreditCard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() { return cardNumber; }

    @Override
    void process() {
        System.out.println("Processing Credit Card payment of $" + getAmount() + " from card: " + cardNumber);
    }
}

// Non-sealed class → can be subclassed freely
non-sealed class PayPal extends Payment {
    private String email;

    PayPal(double amount, String email) {
        super(amount);
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    void process() {
        System.out.println("Processing PayPal payment of $" + getAmount() + " from email: " + email);
    }
}

// Subclass of non-sealed class → allowed
class PayPalBusiness extends PayPal {
    private String businessName;

    PayPalBusiness(double amount, String email, String businessName) {
        super(amount, email);
        this.businessName = businessName;
    }

    @Override
    void process() {
        System.out.println("Processing PayPal Business payment of $" + getAmount() + " from business: " + businessName);
    }
}

// Final class → cannot be subclassed
final class BankTransfer extends Payment {
    private String accountNumber;

    BankTransfer(double amount, String accountNumber) {
        super(amount);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() { return accountNumber; }

    @Override
    void process() {
        System.out.println("Processing Bank Transfer of $" + getAmount() + " from account: " + accountNumber);
    }
}

// Main class
public class PaymentProcessor {
    // Using runtime polymorphism
    public static void processPayment(Payment payment) {
        // Pattern matching (Java 17+) for different types
        if (payment instanceof CreditCard cc) {
            cc.process(); // Call CreditCard-specific processing
        } else if (payment instanceof PayPal pp) {
            pp.process(); // Call PayPal-specific processing
        } else if (payment instanceof BankTransfer bt) {
            bt.process(); // Call BankTransfer-specific processing
        } else {
            System.out.println("Unknown payment type");
        }
    }

    public static void main(String[] args) {
        Payment p1 = new CreditCard(500, "1234-5678-9876-5432");
        Payment p2 = new PayPal(200, "user@example.com");
        Payment p3 = new BankTransfer(1000, "AC987654321");
        Payment p4 = new PayPalBusiness(800, "biz@example.com", "Tech Corp");

        processPayment(p1);
        processPayment(p2);
        processPayment(p3);
        processPayment(p4);
    }
}




//                   ┌───────────────────┐
//                   │      Payment      │   <<sealed, abstract>>
//                   ├───────────────────┤
//                   │ - amount: double  │
//                   ├───────────────────┤
//                   │ + getAmount():double │
//                   │ + process():void  │  <<abstract>>
//                   └────────┬──────────┘
//                            │ permits
//        ┌───────────────┬───────────────┐
//        │               │               │
// ┌─────────────┐  ┌─────────────┐  ┌───────────────┐
// │  CreditCard │  │     PayPal  │  │  BankTransfer │
// │   <<final>> │  │ <<non-sealed>>│ │   <<final>>  │
// ├─────────────┤  ├─────────────┤  ├───────────────┤
// │ - cardNumber│  │ - email     │  │ - accountNumber│
// ├─────────────┤  ├─────────────┤  ├───────────────┤
// │ + process() │  │ + process() │  │ + process()   │
// └─────────────┘  └─────┬───────┘  └───────────────┘
//                        │ subclass allowed
//                        ▼
//                  ┌───────────────┐
//                  │ PayPalBusiness│
//                  ├───────────────┤
//                  │ - businessName│
//                  │ + process()   │
//                  └───────────────┘



// Explanation of the UML

// Payment is a sealed abstract class

// Only CreditCard, PayPal, and BankTransfer can extend it.

// Has an abstract method process().

// Contains private field amount (encapsulation).

// CreditCard and BankTransfer are final

// Cannot have any subclasses.

// PayPal is non-sealed

// Can be subclassed further.

// PayPalBusiness extends PayPal.

// All subclasses implement their own process()

// Demonstrates runtime polymorphism.

// Private fields with getters demonstrate encapsulation.