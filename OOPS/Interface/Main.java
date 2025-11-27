package OOPS.Interface;

interface Vehicle {
    void start();   // public abstract by default
    void stop();    // public abstract by default

    // Static method → belongs to interface, not instance
    static void info() {
        System.out.println("All vehicles follow this interface");
    }

    // Default method → can be inherited by implementing classes
    default void service() {
        System.out.println("Vehicle serviced");
    }
}

// Implementing class
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();       // Car's start
        v.stop();        // Car's stop
        v.service();     // Default method from interface

        Vehicle.info();  // Static method from interface
    }
}
