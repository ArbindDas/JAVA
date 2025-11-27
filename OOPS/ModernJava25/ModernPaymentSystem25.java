
package OOPS.ModernJava25;

// ==================== INTERFACE ====================
interface PaymentProcessor {
    void processPayment();
}

// ==================== SEALED CLASS ====================
sealed abstract class Payment permits CreditCardPayment, PayPalPayment, BankTransferPayment {
    private final double amount;

    Payment(double amount) { this.amount = amount; }

    public double getAmount() { return amount; }

    abstract void validatePayment();
}

// ==================== FINAL CLASS ====================
final class CreditCardPayment extends Payment implements PaymentProcessor {
    private final String cardNumber;

    CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() { return cardNumber; }

    @Override
    void validatePayment() {
        System.out.println("Validating Credit Card: " + cardNumber);
    }

    @Override
    public void processPayment() {
        validatePayment();
        System.out.println("Processing Credit Card payment of $" + getAmount());
    }
}

// ==================== NON-SEALED CLASS ====================
non-sealed class PayPalPayment extends Payment implements PaymentProcessor {
    private final String email;

    PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    void validatePayment() {
        System.out.println("Validating PayPal account: " + email);
    }

    @Override
    public void processPayment() {
        validatePayment();
        System.out.println("Processing PayPal payment of $" + getAmount());
    }
}

// Subclass of non-sealed → scalable addition
class PayPalBusinessPayment extends PayPalPayment {
    private final String businessName;

    PayPalBusinessPayment(double amount, String email, String businessName) {
        super(amount, email);
        this.businessName = businessName;
    }

    @Override
    public void processPayment() {
        System.out.println("""
            Processing PayPal Business payment of $%s for %s
            """.formatted(getAmount(), businessName));
    }
}

// ==================== FINAL CLASS ====================
final class BankTransferPayment extends Payment implements PaymentProcessor {
    private final String accountNumber;

    BankTransferPayment(double amount, String accountNumber) {
        super(amount);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() { return accountNumber; }

    @Override
    void validatePayment() {
        System.out.println("Validating Bank Account: " + accountNumber);
    }

    @Override
    public void processPayment() {
        validatePayment();
        System.out.println("Processing Bank Transfer of $" + getAmount());
    }
}

// ==================== RECORD ====================
record PaymentReceipt(String type, double amount, String reference) {}

// ==================== MAIN CLASS ====================
public class ModernPaymentSystem25 {
    public static void main(String[] args) {
        // Scalable: new payments can be added easily
        Payment[] payments = {
            new CreditCardPayment(500, "1234-5678-9876-5432"),
            new PayPalPayment(200, "user@example.com"),
            new BankTransferPayment(1000, "AC987654321"),
            new PayPalBusinessPayment(800, "biz@example.com", "Tech Corp")
        };

        for (Payment p : payments) {
            // Modern pattern matching → avoids explicit casting
            if (p instanceof PaymentProcessor processor) {
                processor.processPayment();
            }

            // Use record as immutable receipt
            PaymentReceipt receipt = new PaymentReceipt(
                switch(p) {
                    case CreditCardPayment cc -> "Credit Card";
                    case PayPalBusinessPayment pb -> "PayPal Business";
                    case PayPalPayment pp -> "PayPal";
                    case BankTransferPayment bt -> "Bank Transfer";
                    default -> "Unknown";
                },
                p.getAmount(),
                "REF" + (int)(Math.random()*10000)
            );

            System.out.println("Generated Receipt: " + receipt);
            System.out.println("----------------------");
        }
    }
}
