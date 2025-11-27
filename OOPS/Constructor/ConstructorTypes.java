package OOPS.Constructor;

//  An instance = a real object created from a class.
class Student{
    private String name;
    private Integer roll;
    private String address;

    public String getName() {
        return name;
    }

    public Integer getRoll() {
        return roll;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // default constructor
    public  Student(){
        System.out.println(" i am default constructor....");
    }

    // parameterized constructor
    public Student(String name, Integer roll, String address) {
        this.name = name;
        this.roll = roll;
        this.address = address;
    }

    public void printStudentDetails(){
        System.out.println(name);
        System.out.println(roll);
        System.out.println(address);
    }

    public void printStudentDetailsNext(){
        System.out.println(this.name);
        System.out.println(this.roll);
        System.out.println(this.address);
    }

    // copy constructor
    public Student(Student anotherStudent){
        this.name  = anotherStudent.name;
        this.roll = anotherStudent.roll;
        this.address = anotherStudent.address;
    }


    static{
        System.out.println("jai.....");
    }


}
public class ConstructorTypes {
   public static void main(String[] args){

       Student student1 = new Student();
       Student student2 = new Student("Arbind Das" , 4 , "jeetpur");

       student2.printStudentDetails();

       Student copyStudent = new Student(student2);
       System.out.println(copyStudent.getName());

   }
}
