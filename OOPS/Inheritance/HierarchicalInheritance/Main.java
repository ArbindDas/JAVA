package OOPS.Inheritance.HierarchicalInheritance;

public class Main {

    public static void main(String[] args) {

        // Car car = new Car();
        // car.start(); // inherited from Vehicle

        // Bike bike = new Bike();
        // bike.start(); // inherited from Vehicle

        // Bus bus = new Bus();
        // bus.start(); // inherited from Vehicle

        Vehicle[] vehicles = { new Car(), new Bike(), new Bus() };
        for (Vehicle v : vehicles)
            v.start();

        // 1️⃣ Question:
        // "###Can you store different child objects in a single parent reference array?"
        // Yes. In Java, because of inheritance, a parent class reference can point to
        // any object of its child class.
        // This allows us to store multiple child objects in a single array of the
        // parent type.

    }

}
