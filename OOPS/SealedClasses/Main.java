package OOPS.SealedClasses;

sealed class Vehicle permits Car, Bike {
    void info() {
        System.out.println("This is a vehicle");
    }
}

// final class → cannot be subclassed
final class Car extends Vehicle {
    void type() {
        System.out.println("Car is a final class");
    }
}

// non-sealed class → can be subclassed further
non-sealed class Bike extends Vehicle {
    void type() {
        System.out.println("Bike is a non-sealed class");
    }
}

// subclass of non-sealed class → allowed
class SportsBike extends Bike {
    void type() {
        System.out.println("SportsBike extends non-sealed Bike");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.info();

        Vehicle bike = new Bike();
        bike.info();

        Bike sbike = new SportsBike();
        sbike.type();
    }
}




// sealed → restrict inheritance

// final → no further inheritance

// non-sealed → open for further inheritance

// Packages: For simplicity, put sealed class and its permitted subclasses in the same package.