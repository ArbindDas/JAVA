package OOPS.Inheritance.HierarchicalInheritance;

public class Bike extends Vehicle {



    @Override
     public void start() {
        System.out.println("Vehicle started");
    }

    private String handleType;
     public void showBike() {
        System.out.println("Bike handle: " + handleType);
    }
    
}
