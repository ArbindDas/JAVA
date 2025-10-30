package Test22;



class Student{

    public Student() {
        System.out.println("i am constructor");
    }

    static {
        System.out.println("i am static field");
    }

    public void show(){
        System.out.println("i am a method");
    }
}
public class main {
    static void main(String[] args) {

        Student student = new Student();
    }
}
