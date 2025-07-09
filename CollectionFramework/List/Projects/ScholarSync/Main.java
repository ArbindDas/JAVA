package CollectionFramework.List.Projects.ScholarSync;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner ( System.in );
    private static List < Student > students = new ArrayList <> ( );

    public static void main( String[] args ) {

        boolean running = true;
        while ( running ) {
            DisplayMenu ( );

            int choice = getIntInput ( "Enter the choice" );


            switch (choice) {
                case 1:
                    addStudent ( );
                    break;
                case 2:
                    removeStudent ( );
                    break;

                case 3:
                    updateStudent ( );
                    break;

                case 4:
                    viewAllStudents ( );
                    break;

                case 5:
                    searchStudent ( );
                    break;

                case 6:
                    sortStudents ( );
                    break;


                default:
                    System.out.println ( "Invalid choice. Please try again." );
            }

        }


    }

    private static void sortStudents( ) {
    }

    private static void searchStudent( ) {
    }

    private static void viewAllStudents( ) {
    }

    private static void updateStudent( ) {

        System.out.println("\n--- Update Student Info ---");
        String id = getStringInput("Enter student ID to update: ");


        Student foundStudent = null;


        for ( Student student : students ){
            if (student.getId ().equalsIgnoreCase ( id )){
                foundStudent = student;
                break;
            }
        }
        if (foundStudent==null){
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.println ("current student information : "+ foundStudent );
        System.out.println("Enter new information (leave blank to keep current):");


        String name = getStringInput ( "Enter the name [" + foundStudent.getName () + "]: ");
        if (!name.isEmpty ()){
            foundStudent.setName ( name );
        }

    }

    private static void removeStudent( ) {
        System.out.println ("\n---- Remove Student----" );
        String id = getStringInput ( "Enter the student id to remove...." );

        boolean removed = false;

        for ( int i = 0; i<students.size (); i++ ){
            if (students.get ( i ).getId ().equalsIgnoreCase ( id )){
                students.remove ( i );
                removed=true;
                break;
            }
        }
        if (removed){
            System.out.println ("Student removed successfully ....." );
        }else {
            System.out.println ("Student with id : "+ id + " not found");
        }
    }

    private static void addStudent( ) {
        System.out.println ( "\n--- Add New Student ---" );
        String id = getStringInput ( "Enter student ID:" );
        for ( Student student : students ) {
            if (student.getId ( ).equalsIgnoreCase ( id )) {
                System.out.println ( "Student with this ID already exists!" );
                return;
            }
        }
        String name = getStringInput ( "Enter the student name..." );
        int age = getIntInput ( "Enter the student age.." );
        String course = getStringInput ( "Enter the course name ....." );
        students.add ( new Student ( id , name , age , course ) );
        System.out.println ( "Student added Successfully ...." );
    }


    private static void DisplayMenu( ) {
        System.out.println ( "\n.......Student Management System......" );
        System.out.println ( "1. Add new Student" );
        System.out.println ( "2.Remove Student by Id" );
        System.out.println ( "3.update Student Info" );
        System.out.println ( "4. view all Student" );
        System.out.println ( "5.search Student by ID or Name" );
        System.out.println ( "6. Student" );
        System.out.println ( "7. Exit" );
        System.out.println ( "===================================" );

    }

    private static int getIntInput( String prompt ) {
        while ( true ) {
            try {
                System.out.println ( prompt );
                return Integer.parseInt ( scanner.nextLine ( ) );
            } catch (NumberFormatException e) {
                throw new RuntimeException ( e );
            }
        }
    }

    private static String getStringInput( String prompt ) {
        while ( true ) {
            try {
                System.out.println ( prompt );
                return scanner.nextLine ( );
            } catch (RuntimeException e) {
                throw new RuntimeException ( e );
            }
        }
    }
}
