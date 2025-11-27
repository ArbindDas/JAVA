package OOPS.Polymorphism;

// Interface representing a generic vehicle feature
interface VehicleFeature {
    void start();       // abstract method → must be implemented
    void stop();        // abstract method → must be implemented

    // Default method → shared behavior, optional to override
    default void service() {
        System.out.println("Vehicle serviced");
    }

    // Static method → belongs to interface itself, cannot be overridden
    static void info() {
        System.out.println("All vehicles implement VehicleFeature");
    }
}

// Abstract class representing a generic vehicle
// Purpose: Provides abstraction and common methods for all vehicles
abstract class Vehicle implements VehicleFeature {
    String name;

    // Constructor → initializes common property
    Vehicle(String name) {
        this.name = name;
        System.out.println(name + " vehicle created");
    }

    // Final method → cannot be overridden
    // Purpose: Ensures all vehicles follow same registration process
    final void registerVehicle() {
        System.out.println(name + " registered successfully");
    }

    // Abstract method → must be implemented by subclass
    abstract void fuel();   // runtime polymorphism example
}

// Concrete class representing a Car
class Car extends Vehicle {
    Car() {
        super("Car");   // Calls abstract class constructor
    }

    // Implement abstract method from Vehicle (runtime polymorphism)
    @Override
    void fuel() {
        System.out.println("Car uses petrol/diesel");
    }

    // Implement interface methods (runtime polymorphism)
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    // Method overloading → compile-time polymorphism
    void music(String type) {
        System.out.println("Playing " + type + " music");
    }

    void music(String type, int volume) {
        System.out.println("Playing " + type + " music at volume " + volume);
    }
}

// Concrete class representing a Bike
class Bike extends Vehicle {
    Bike() {
        super("Bike");   // Calls abstract class constructor
    }

    @Override
    void fuel() {
        System.out.println("Bike uses petrol");
    }

    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }
}

public class Main {
    public static void main(String[] args) {
        // Compile-time polymorphism example (method overloading)
        Car car = new Car();
        car.music("Pop");
        car.music("Rock", 10);

        System.out.println("----------------------");

        // Runtime polymorphism: parent reference pointing to subclass object
        Vehicle vehicle;

        vehicle = new Car();
        vehicle.registerVehicle();   // final method → cannot be overridden
        vehicle.start();             // overridden method → Car's start
        vehicle.fuel();              // overridden method → Car's fuel
        vehicle.service();           // default method from interface

        System.out.println("----------------------");

        vehicle = new Bike();
        vehicle.registerVehicle();   // final method
        vehicle.start();             // Bike's start
        vehicle.fuel();              // Bike's fuel
        vehicle.service();           // default method

        System.out.println("----------------------");

        // Calling static method from interface
        VehicleFeature.info();       // interface static method
    }
}
