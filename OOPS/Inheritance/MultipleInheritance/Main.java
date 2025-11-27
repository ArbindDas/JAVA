package OOPS.Inheritance.MultipleInheritance;





interface Engine {
    void start();
}

interface GPS {
    void navigate();

    default void checkFuel() {
        System.out.println("Checking fuel level...");
    }
}

class Car implements Engine, GPS {
    @Override
    public void start() {
        System.out.println("Car engine started");
    }

    @Override
    public void navigate() {
        System.out.println("Car navigating...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.navigate();
    }
}
