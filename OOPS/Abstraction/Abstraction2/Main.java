package OOPS.Abstraction.Abstraction2;

abstract class ATM {
    String bankName;

    // Constructor of abstract class
    ATM(String bankName) {
        this.bankName = bankName;
        System.out.println(bankName + " ATM initialized");
    }

    abstract void withdraw(int amount);

    final void insertCard() {
        System.out.println("Card inserted");
    }
}

class SBIATM extends ATM {
    SBIATM() {
        super("SBI"); // Calls abstract class constructor
    }

    @Override
    void withdraw(int amount) {
        System.out.println("SBI ATM withdrawing: Rs. " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new SBIATM(); // Constructor of ATM is called first
        atm.insertCard();
        atm.withdraw(5000);
    }
}


// Key Points

// Abstract class constructor is called whenever a subclass object is created.

// Used to initialize common properties or perform setup logic for all subclasses.

// You cannot do new ATM(), but the constructor still runs when a subclass is instantiated.

// Works well with final methods, fields, and abstraction to provide a complete base template.



// “Abstract classes can have constructors. They are used to initialize common fields or perform setup for subclasses. 
// Even though we cannot instantiate an abstract class, its constructor is called when a concrete subclass object is created.”