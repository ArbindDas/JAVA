package CollectionFramework.List.Projects.ScholarSync;

import java.util.*;

public class Main {
    public  static  int getIntegerInput(String prompt){
        System.out.println(prompt);
        try {

            return Integer.parseInt( sc.nextLine() );

        }catch (NumberFormatException e){
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static String getStringInput(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    private static final Scanner sc = new Scanner( System.in );

    public static final List < Student > studentList = new ArrayList <>();

    private static final Map < String, String > studentMap = new HashMap <>();

    public static void main( String[] args ) {

        while ( true ){
            Display();

            String Choice = getStringInput( "Enter the choice " );

            switch (Choice.toLowerCase().trim()){

                case "addstudent" -> addstudent();

                case "removestudent" -> removestudent();

                case "viewstudent" -> viewstudent();

                case  "countstudent" -> countstudent();

                case "updatestudent" -> updatestudent();

                case "exit" -> {
                    try {
                        Thread.sleep( 10 );
                    } catch (InterruptedException e) {
                        throw new RuntimeException( e );
                    }
                    System.out.println("Exiting......");
                    return;
                }
            }
        }



    }

    private static void updatestudent( ) {
        Checker( studentList );
        System.out.println("updating.....");

        int id = getIntegerInput( "Enter the id to be updated...." );






       Student foundStudent = null;

       for ( Student student : studentList ){
           if (student.getId()==id){
               foundStudent = student;
               break;
           }
       }

       if (foundStudent==null){
           System.out.println("there is no student with id : "+ id);
       }

        System.out.println("current student info is : "+ foundStudent);
        System.out.println("now enter the new values ...");



        String newName = getStringInput( "Enter the new name["+foundStudent.getName() + "]" );
        if (!newName.isEmpty()){
            foundStudent.setName( newName );
        }

        String newAge = getStringInput( "Enter the new age["+foundStudent.getAge()+"]" );
        if (!newAge.isEmpty()){
            foundStudent.setAge(Integer.parseInt( newAge ));
        }

        String newCourse = getStringInput( "Enter the new Course["+foundStudent.getCourse()+"]" );
        if (!newCourse.isEmpty()){
            foundStudent.setCourse( newCourse );
        }

        System.out.println("Student information updated successfully!");
        System.out.println("updated student is : "+ foundStudent);

    }

    private static void countstudent( ) {
       long totalStudent = studentList.size();
        System.out.println( STR."the total student in your list is => \{totalStudent}" );
    }

    private static void viewstudent( ) {
        Checker(studentList);
        System.out.println("the student are ");
        for ( Student student : studentList ){
            System.out.println(student);
        }
    }

    private static void Checker( List< Student> studentList ) {
        if (studentList.isEmpty()){
            System.out.println("there is no student in your list please add first the student and then do this task");
            return;
        }
    }

    private static void removestudent( ) {
        System.out.println(" Removing student ");
        Checker( studentList );
        int id = getIntegerInput( "Enter the student id to be removed" );
        boolean removed = false;
        for ( int i = 0; i<studentList.size(); i++ ){
            if (studentList.get( i ).getId() == id){
                studentList.remove( i );
                removed = true;
                break;
            }
        }
        System.out.println( STR."Successfully student is removed id is \{id}" );
    }

    private static void addstudent( ) {

        System.out.println("Add A New Student");

        int id = getIntegerInput( "Enter the Id" );
        String name = getStringInput( "Enter the Name" );
        int age = getIntegerInput( "Enter the age" );
        String course = getStringInput( "Enter the Course" );


        studentList.add( new Student(id , name , age , course) );
    }

    public static void Display(){
        System.out.println("------------- The ScholarSync Project --------------");
        System.out.println("addstudent");
        System.out.println("removestudent");
        System.out.println("viewstudent");
        System.out.println("coutstudent");
        System.out.println("updatestudent");
        System.out.println("5.Sort Student");
        System.out.println("6.Exit");
    }
}