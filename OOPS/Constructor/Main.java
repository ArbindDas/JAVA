package OOPS.Constructor;


class Student{
    private int studentId;
    private String studentName;
    private String studentAddress;

    public Student( int studentId , String studentName , String studentAddress ) {
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentAddress=studentAddress;
    }

    public Student(  ) {

    }


    public Student(Student newStudent){
       this.studentId = newStudent.studentId;
       this.studentName = newStudent.studentName;
       this.studentAddress = newStudent.studentAddress;
    }

    public int getStudentId( ) {
        return studentId;
    }

    public String getStudentName( ) {
        return studentName;
    }

    public String getStudentAddress( ) {
        return studentAddress;
    }

    public void setStudentId( int studentId ) {
        this.studentId=studentId;
    }

    public void setStudentName( String studentName ) {
        this.studentName=studentName;
    }

    public void setStudentAddress( String studentAddress ) {
        this.studentAddress=studentAddress;
    }

    void printStudentDetails( ){
        System.out.println ( STR."StudetId : \{this.studentId}" );
        System.out.println ( STR."StudentName : \{this.studentName}" );
        System.out.println ( STR."StudentAddress : \{this.studentAddress}" );
    }
}
public class Main
{
    public static void main( String[] args ) {



        Student student = new Student ( 1  , "Arvind Das", "Bara" );

        Student copy = new Student ( student );
        // copy constructor
        copy.printStudentDetails();

    }
}
