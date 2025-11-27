package OOPS.Inheritance.MultilevelInheritance;

// Base class (Grandparent)
public class Person {

    private String name;

    public Person(String name){
        this.name=name;
        System.out.println("Person constructor called...");
    }


    public void show(){

        System.out.println("name" + name);
    }
    
}


 class Employee  extends Person{


    protected int employeeId;

    public Employee( String name , int employeeId){
        super(name);
        this.employeeId =employeeId;
        System.out.println("Employee constructor called");
    }


    @Override
    public void show(){
        super.show();
        System.out.println("Employee ID: " + employeeId);
    }
}

 class Manager extends Employee {


    private String department;

    public Manager(String name  , int employeeId, String department){
        super(name, employeeId);
        this.department = department;
        System.out.println("Manager constructor called");
    }
    

     @Override
    public void show() {
        super.show(); // Call Employee's method
        System.out.println("Department: " + department);
    }
}
