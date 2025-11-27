package OOPS.Inheritance.MultilevelInheritance;

public class Main {
    public static void main(String[] args) {
        

       // Multilevel inheritance in action
        Manager manager = new Manager("Arbind", 101, "IT");

        System.out.println("\nPrinting Details using Manager object:");
        manager.show();

        // Polymorphism: reference type Employee
        Employee emp = new Manager("Sita", 102, "HR");
        System.out.println("\nPrinting Details using Employee reference:");
        emp.show();


        
         
    }
}
