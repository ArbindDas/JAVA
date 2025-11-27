package OOPS.Abstraction;

// Abstract class representing a generic ATM
// Purpose: To provide abstraction – hide internal implementation details and provide a template for all ATMs
abstract class ATM {
    // Abstract method → must be implemented by every subclass
    // Purpose: Ensures each ATM defines its own withdraw behavior
    abstract void withdraw(int amount);

    // Concrete method → common functionality provided to all ATMs
    // Purpose: Shared functionality that does not change per ATM
    void insertCard() {
        System.out.println("Card inserted");
    }

    // Concrete method → common functionality
    // Purpose: Shared logic to verify PIN, same for all ATMs
    void enterPin() {
        System.out.println("PIN verified");
    }
}

// Concrete subclass representing SBI ATM
// Purpose: Implements the abstract withdraw method specific to SBI
class SBIATM extends ATM {
    @Override
    void withdraw(int amount) {
        // SBI-specific withdrawal logic
        System.out.println("SBI ATM withdrawing: Rs. " + amount);
    }
}

// Concrete subclass representing ICICI ATM
// Purpose: Implements the abstract withdraw method specific to ICICI
class ICICIATM extends ATM {
    @Override
    void withdraw(int amount) {
        // ICICI-specific withdrawal logic
        System.out.println("ICICI ATM withdrawing: Rs. " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        // Abstract class reference
        // Purpose: Demonstrates abstraction and runtime polymorphism
        ATM atm;

        // Using SBI ATM
        atm = new SBIATM();  // SBIATM object assigned to ATM reference
        atm.insertCard();    // Calls concrete method from ATM class
        atm.enterPin();      // Calls concrete method from ATM class
        atm.withdraw(5000);  // Calls SBIATM implementation of withdraw()

        System.out.println("----------------------");

        // Using ICICI ATM
        atm = new ICICIATM();  // ICICIATM object assigned to same ATM reference
        atm.insertCard();      // Calls same shared concrete method
        atm.enterPin();        // Calls same shared concrete method
        atm.withdraw(3000);    // Calls ICICIATM implementation of withdraw()

        // Purpose of this approach:
        // 1. Shows abstraction: code depends on ATM, not concrete implementation
        // 2. Enables polymorphism: same reference can point to different ATM types
        // 3. Loose coupling: business logic is independent of specific ATM type
        // 4. Scalable: new ATM types can be added easily without changing main logic
    }
}
